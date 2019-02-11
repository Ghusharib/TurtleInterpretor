package turtle;

import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class Turtle {
    private int x;
    private int y;
    private Direction direction;
    private Pen penState;
    private Paper paper;
    private char brush;

    public Turtle(Paper paper){
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
        this.penState = Pen.UP;
        this.paper = paper;
        this.brush = '*';
    }

    public void liftPen(){
        if (penState == Pen.UP) {
            penState = Pen.DOWN;
        } else {
            penState = Pen.UP;
        }
    }

    public void changeBrush(char c){
        brush = c;
    }

    public void rotate(Rotation rotation, int n){
        for (int i = 0; i < n; i++){
            direction.rotate(rotation);
        }
    }

    public void mark(){
        if (penState == Pen.DOWN){
            paper.mark(x, y, brush);
        }
    }

    public void move(int n){
        int dir = direction.ordinal(); //stores the num value of the direction
        for (int i = 0; i < n; i++){
            if(dir == 0 || dir == 1 || dir == 8){
                y++;
            }
            if (dir >= 1 && dir <= 3){
                x++;
            }
            if (dir >= 3 && dir <= 5){
                y--;
            }
            if (dir >= 5 && dir <= 8){
                x--;
            }
            if(!paper.withinBounds(x, y)){
                goBack();
                break;
            }
            mark();
        }
    }

    private void goBack(){
        direction = Direction.values()[(direction.ordinal() + 4)%8];
        move(1);
        direction = Direction.values()[(direction.ordinal() + 4)%8];
    }

}
