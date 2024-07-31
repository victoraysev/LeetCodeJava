package longestnicesubstring1763;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (isNice(s.substring(i, j))) {
                    String candidateAnswer = s.substring(i, j);
                    if (candidateAnswer.length() > ans.length()) {
                        ans = candidateAnswer;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isNice(String substring) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : substring.toCharArray()) {
            if (map.containsKey((char) (c + 32))) {
                map.put((char) (c + 32), true);
            } else if (map.containsKey((char) (c - 32))) {
                map.put((char) (c - 32), true);
            } else {
                map.putIfAbsent(c, false);
            }
        }
        return !map.values().contains(false);
    }

    public static void main(String[] args) {
        var x = new Solution().longestNiceSubstring("Bb");
        System.out.println(x);
    }
}