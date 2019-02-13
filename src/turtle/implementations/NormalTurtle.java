package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class NormalTurtle extends AbstractTurtle {

    public NormalTurtle(Paper paper, int x, int y){
        super (paper, x, y);
    }

    @Override
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
