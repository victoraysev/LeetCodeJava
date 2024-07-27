package lettercombinationsofaphonenumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> result = new ArrayList<String>();
        recursive("", digits, map, result);
        return result
                ;
    }

    private void recursive(String s, String digits, Map<Character,char[]> map, List<String> result) {
        if(digits.length() == 0){
            return;
        }
        if(s.length() == digits.length()){
            result.add(s);
            return;
        }
        char[] chars = map.get(digits.charAt(s.length()));
        for(char c : chars){
            recursive(s + c, digits, map, result);
        }
    }

}
