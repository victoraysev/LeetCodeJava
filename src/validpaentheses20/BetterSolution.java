package validpaentheses20;

import java.util.Stack;

public class BetterSolution {
    public boolean isValid(String s){
        Stack<Character> characters = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '{'){
                characters.push('}');
            }
            if(c == '('){
                characters.push(')');

            }
            if(c == '['){
                characters.push(']');
            }
            if(characters.isEmpty() || characters.pop() != c){
                return false;
            }
        }
        return characters.isEmpty();
    }
}
