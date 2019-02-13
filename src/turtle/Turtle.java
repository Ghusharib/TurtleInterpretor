package turtle;

import turtle.util.Rotation;

public interface Turtle {

    public void liftPen();
    public void dropPen();
    public void changeBrush(char c);
    public void rotate(Rotation rotation, int n);
    public void mark();
    public void move(int n);
}
