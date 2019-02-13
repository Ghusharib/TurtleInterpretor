package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class AbstractTurtle implements Turtle {
    protected int x;
    protected int y;
    protected Direction direction;
    protected Pen penState;
    protected Paper paper;
    protected char brush;

    public AbstractTurtle(Paper paper, int x, int y){
        this.x = x;
        this.y = y;
        this.direction = Direction.NORTH;
        this.penState = Pen.UP;
        this.paper = paper;
        this.brush = '*';
    }

    public void liftPen(){
        penState = Pen.UP;
    }

    public void dropPen(){
        penState = Pen.DOWN;
    }

    public void changeBrush(char c){
        brush = c;
    }

    public void rotate(Rotation rotation, int n){
        for (int i = 0; i < n; i++){
            direction = direction.rotate(rotation);
        }
    }

    public void mark(){
        if (penState == Pen.DOWN){
            paper.mark(x, y, brush);
        }
    }

    public void move(int n){

    }

}
