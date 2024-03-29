package turtle.implementations;

import turtle.Paper;

public class ContinuousTurtle extends AbstractTurtle{

    public ContinuousTurtle(Paper paper, int x, int y){
        super(paper, x, y);
    }

    public void move(int n){
        for (int i = 0; i < n; i++){
            int dir = direction.ordinal(); //stores the num value of the direction
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
            if(paper.withinBounds(x, y)){
                mark();
            }
        }
    }
}
