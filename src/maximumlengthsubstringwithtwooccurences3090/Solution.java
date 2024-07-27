package maximumlengthsubstringwithtwooccurences3090;
import java.util.*;
class Solution {
    public int maximumLengthSubstring(String s) {
        int i = 0;
        int j = 1;
        int max = 1;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(i), 1);
        while(i < n && j < n){
            char c = s.charAt(j);
            map.merge(c, 1, Integer::sum);
            while(map.get(c) > 2){
                map.merge(s.charAt(i), 0, (oldValue, defaultValue) -> oldValue - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        var x = new Solution().maximumLengthSubstring("bcbbbcba");
        System.out.println(x);
    }
}