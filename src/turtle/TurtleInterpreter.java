package turtle;

import turtle.util.Rotation;

import java.io.PrintStream;
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
                    newTurtle();
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
    }

    private void newTurtle(){
        input.next();
        String name = input.next();
        int x = input.nextInt();
        int y = input.nextInt();
        turtles.put(name, new Turtle(paper, x, y));
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
