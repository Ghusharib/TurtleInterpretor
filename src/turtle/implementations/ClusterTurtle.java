package turtle.implementations;

import turtle.Turtle;
import turtle.util.Rotation;

import java.util.ArrayList;

public class ClusterTurtle implements Turtle {

    private ArrayList<Turtle> cluster = new ArrayList<>();

    public ClusterTurtle(ArrayList<Turtle> cluster){
        this.cluster = cluster;
    }

    public void liftPen(){
        for(int i = 0; i < cluster.size(); i++){
            cluster.get(i).liftPen();
        }
    }

    public void dropPen(){
        for(int i = 0; i < cluster.size(); i++){
            cluster.get(i).dropPen();
        }
    }

    public void changeBrush(char c){
        for(int i = 0; i < cluster.size(); i++){
            cluster.get(i).changeBrush(c);
        }
    }

    public void rotate(Rotation rotation, int n){
        for(int i = 0; i < cluster.size(); i++){
            cluster.get(i).rotate(rotation, n);
        }
    }

    public void mark(){
        for(int i = 0; i < cluster.size(); i++){
            cluster.get(i).mark();
        }
    }

    public void move(int n){
        for(int i = 0; i < cluster.size(); i++){
            cluster.get(i).move(n);
        }
    }

    public void addTurtle(Turtle turtle){
        cluster.add(turtle);
    }
}
