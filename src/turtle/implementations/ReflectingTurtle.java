package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Rotation;

public class ReflectingTurtle extends AbstractTurtle{

    public ReflectingTurtle(Paper paper, int x, int y){
        super(paper, x, y);
    }

    @Override
    public void move(int n){
        for (int i = 0; i < n; i++){
            int dir = direction.ordinal(); //stores the num value of the direction
            int oldX = x;
            int oldY = y;
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
                x = oldX;
                y = oldY;
                reflect();
            }
            mark();
        }
    }

    private void reflect(){
        if((direction == direction.NORTH) || (direction == direction.SOUTH) || (direction == direction.EAST) || (direction == direction.WEST)){
            rotate(Rotation.RIGHT, 4);
        } else if (direction == direction.NORTH_EAST) {
            if (x == paper.getWidth() - 1 && y == paper.getHeight() - 1){
                rotate(Rotation.RIGHT, 4);
            } else if(x == paper.getWidth() - 1){
                y++;
                rotate(Rotation.LEFT, 2);
            } else {
                x++;
                rotate(Rotation.RIGHT, 2);
            }
        } else if (direction == direction.SOUTH_EAST) {
            if (x == paper.getWidth() - 1 && y == 0){
                rotate(Rotation.RIGHT, 4);
            } else if(x == paper.getWidth() - 1){
                y--;
                rotate(Rotation.RIGHT, 2);
            } else if (y == 0){
                x++;
                rotate(Rotation.LEFT, 2);
            }
        } else if (direction == direction.NORTH_WEST) {
            if (x == 0 && y == paper.getHeight() - 1){
                rotate(Rotation.RIGHT, 4);
            } else if(y == paper.getHeight() - 1){
                x--;
                rotate(Rotation.LEFT, 2);
            } else if (x == 0){
                y++;
                rotate(Rotation.RIGHT, 2);
            }
        } else if (direction == direction.SOUTH_WEST) {
            if (x == 0 && y == 0){
                rotate(Rotation.RIGHT, 4);
            } else if(x == 0){
                y--;
                rotate(Rotation.LEFT, 2);
            } else if (y == 0){
                x--;
                rotate(Rotation.RIGHT, 2);
            }
        }
    }



}
