package validpaentheses20;

import java.util.*;

public class Solution {
    public boolean isValid(String s){
        Set<Character> openers = Set.of('(', '{', '[');
        Set<Character> closers = Set.of(')', '}', ']');
        Map<Character, Character> map = Map.of(
                ')','(',
                '}','{',
                ']','['
        );
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(openers.contains(c)){
                stack.push(c);
            }
            else{
                try {
                    Character elem = stack.pop();
                    if(!map.get(c).equals(elem)){
                        return false;
                    }
                }catch (EmptyStackException e){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
