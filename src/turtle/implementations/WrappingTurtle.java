package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;

public class WrappingTurtle extends AbstractTurtle {

    public WrappingTurtle(Paper paper, int x, int y){
        super(paper, x, y);
    }

    @Override
    public void move(int n){
        for (int i = 0; i < n; i++){
            int dir = direction.ordinal(); //stores the num value of the direction
            if(dir == 0 || dir == 1 || dir == 7){
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
                wrap();
            }
            mark();
        }
    }

    private void wrap(){
        x = Math.floorMod(x, paper.getWidth());
        y = Math.floorMod(y, paper.getHeight());
    }
}
