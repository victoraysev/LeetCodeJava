package palindromepartitioning131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, ArrayList<String> step, List<List<String>> result) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (!isPalindrome(temp)) continue;
            step.add(temp);
            helper(s.substring(i), step, result);
            step.remove(step.size() - 1);
        }
    }

    private boolean isPalindrome(String temp) {
        int i = 0;
        int j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<String>> res = new Solution().partition("efe");
        System.out.println(res);
    }
}
