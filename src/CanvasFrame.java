import java.awt.*;
import java.util.Queue;
import java.util.Stack;

public class CanvasFrame extends Canvas{
/**
 * Written by Logan Dabney 11/13/18
 * This class creates a canvas object with the a function, angle and current state.
 */
Queue<Character> function;
double angle;
currentPosition currentState;
public CanvasFrame(Queue<Character> function, double angle, String start) {
    this.function = function;
    this.angle = angle;
    switch (start) {
        case "Center": {
            currentState = new currentPosition(500.0, 500.0, 0);
            break;
        }
        case "Bottom Left": {
            currentState = new currentPosition(0.0, 890.0, 0);
            break;
        }
        case "Top Left": {
            currentState = new currentPosition(0.0, 0.0, 0);
            break;
        }
        case "Left Center": {
            currentState = new currentPosition(0.0, 500.0, 0);
            break;
        }
        case "Bottom Center": {
            currentState = new currentPosition(500.0, 890.0, 0);
            break;
        }
    }
}

/**
 * This class is override from the original paint to create the lines from the given
 * function, angle and current state.
 * @param gInit
 */
    @Override
    public void paint(Graphics gInit) {
    super.paint(gInit);
    Graphics2D g = (Graphics2D)gInit;
        Stack<currentPosition> position = new Stack<>();
        double nextX, nextY;

        while (function.size() > 0) {
            if (Character.isLetter(function.peek()) && function.peek().equals('F')) {
                function.remove();
                nextX = currentState.x + (2 * Math.sin(Math.toRadians(currentState.angle)));
                nextY = currentState.y - (2 * Math.cos(Math.toRadians(currentState.angle)));
                g.drawLine((int) Math.round(currentState.x), (int) Math.round(currentState.y),
                        (int) Math.round(nextX), (int) Math.round(nextY));
                currentState = new currentPosition(nextX, nextY, currentState.angle);
            }else if(Character.isLetter(function.peek()) && !function.peek().equals('F')){
                function.remove();
            }else if (function.peek().equals('+')) {
                function.remove();
                currentState = new currentPosition(currentState.x, currentState.y, (currentState.angle + angle));
            } else if (function.peek().equals('-')) {
                function.remove();
                currentState = new currentPosition(currentState.x, currentState.y, (currentState.angle - angle));
            } else if (function.peek().equals('[')) {
                function.remove();
                position.push(currentState);
            } else if (function.peek().equals(']')) {
                if (!position.isEmpty()) {
                    function.remove();
                    currentState = position.pop();
                }
            }
        }
    }
}

/**
 * This creates an object of the current position of the drawing.
 */
class currentPosition {
    public double x, y, angle;
    currentPosition(double x, double y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
    }
}