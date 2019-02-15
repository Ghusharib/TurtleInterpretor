package turtle;

import turtle.implementations.*;
import turtle.util.Rotation;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TurtleInterpreter {

    private final Map<String, Turtle> turtles = new HashMap<>();
    private Scanner input;
    private PrintStream output;
    private Paper paper;


    public TurtleInterpreter(Scanner input, PrintStream output){
        this.input = input;
        this.output = output;
        this.paper = new Paper();
        processCommands();
    }

    private void processCommands(){
        while (input.hasNext()){
            String command = input.next();
            switch (command) {
                case "paper":
                    newPaper();
                    break;
                case "new":
                    newTurtle("");
                    break;
                case "pen":
                    changePen();
                    break;
                case "move":
                    move();
                    break;
                case "right":
                    right();
                    break;
                case "left":
                    left();
                    break;
                case "show":
                    show();
                    break;
            }
        }
    }

    private void newPaper(){
        int width = input.nextInt();
        int height = input.nextInt();
        paper = new Paper(width, height);
        turtles.clear();
    }

    private Turtle newTurtle(String prefix){
        String type = input.next();
        String name = prefix + input.next();
        int x = 0, y = 0;
        if(!type.equals("cluster")){
            x = input.nextInt();
            y = input.nextInt();
        }
        Turtle turtle = new NormalTurtle(paper, x, y);
        if (type.equals("bouncy")) {
            turtle = new BouncyTurtle(paper, x, y);
        } else if (type.equals("continuous")) {
            turtle = new ContinuousTurtle(paper, x, y);
        } else if (type.equals("wrapping")) {
            turtle = new WrappingTurtle(paper, x ,y);
        } else if (type.equals("reflecting")) {
            turtle = new ReflectingTurtle(paper, x, y);
        } else if (type.equals("cluster")) {
            turtle = new ClusterTurtle(new ArrayList<Turtle>());
            int size = input.nextInt();
            for(int i = 0; i < size; i++){
                if(!input.next().equals("new")){
                    throw new RuntimeException("Error: invalid command for cluster");
                }
                ((ClusterTurtle) turtle).addTurtle(newTurtle(name + "."));
            }
        }
        turtles.put(name, turtle);
        return turtle;
    }

    private void changePen(){
        String name = input.next();
        String state = input.next();
        Turtle turtle = turtles.get(name);
        if (state.equals("up")){
            turtle.liftPen();
        } else if (state.equals("down")) {
            turtle.dropPen();
        } else {
            turtle.changeBrush(state.charAt(0));
        }
    }

    private void move(){
        String name = input.next();
        int distance = input.nextInt();
        turtles.get(name).move(distance);
    }

    private void right(){
        String name = input.next();
        int angle = input.nextInt();
        turtles.get(name).rotate(Rotation.RIGHT, angle/45);
    }

    private void left(){
        String name = input.next();
        int angle = input.nextInt();
        turtles.get(name).rotate(Rotation.LEFT, angle/45);

    }

    private void show(){
        output.print(paper.toString());
    }
}
