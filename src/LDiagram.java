import java.util.LinkedList;
import java.util.Queue;

public class LDiagram {
/**
 * Written by Logan Dabney 11/13/18
 * This class creates an object with the rules, start of function and number of iteration.
 */
public String rule1, rule2, rule3, rule4, rule5, startOfFunction;
    public int iterations;
    public LDiagram(String r1, String r2, String r3, String r4, String r5, String start, int it) throws Exception {
        rule1 = r1 + " ";
        rule2 = r2 + " ";
        rule3 = r3 + " ";
        rule4 = r4 + " ";
        rule5 = r5 + " ";
        if (Character.isLetter(start.charAt(0)) && start.length() == 1){
            startOfFunction = start;
        } else {
            throw new Exception("The start of the function must be a single letter that matches on of the rules." +
                    " Try again.");
        }
        iterations = it;
    }

/**
 *
 * @return This returns the fully expanded function for creating the L-system
 * @throws Exception
 */
public Queue<Character> getEndFunction() throws Exception {
        int size;
        Queue<Character> endFunction = new LinkedList<>();
        endFunction.add(startOfFunction.charAt(0));

    while(iterations > 0){
        size = endFunction.size();
        for (int i = 0; i < size; i++){
            if(endFunction.peek().equals(rule1.charAt(0))){
                endFunction.remove();
                for (int a = 2; a < rule1.length() - 1; a++){
                    endFunction.add(rule1.charAt(a));
                }
            } else if(endFunction.peek().equals(rule2.charAt(0))){
                endFunction.remove();
                for (int a = 2; a < rule2.length() - 1; a++){
                    endFunction.add(rule2.charAt(a));
                }
            } else if(endFunction.peek().equals(rule3.charAt(0))){
                endFunction.remove();
                for (int a = 2; a < rule3.length() - 1; a++){
                    endFunction.add(rule3.charAt(a));
                }
            } else if(endFunction.peek().equals(rule4.charAt(0))){
                endFunction.remove();
                for (int a = 2; a < rule4.length() - 1; a++){
                    endFunction.add(rule4.charAt(a));
                }
            } else if(endFunction.peek().equals(rule5.charAt(0))){
                endFunction.remove();
                for (int a = 2; a < rule5.length() - 1; a++){
                    endFunction.add(rule5.charAt(a));
                }
            } else if(endFunction.peek().equals('+') || endFunction.peek().equals('-')){
                endFunction.add(endFunction.remove());
            } else if(endFunction.peek().equals('[') || endFunction.peek().equals(']')){
                endFunction.add(endFunction.remove());
            } else{
                throw new Exception("You have entered a wrong character! Allowed characters (+, -, [, ], and all letters");
            }
        }
        iterations--;
    }
    return endFunction;
}
}
