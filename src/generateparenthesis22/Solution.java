package generateparenthesis22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        recursive(0,0,"", arr, n);
        return arr;
    }

    private void recursive (int left, int right, String p, List<String> res, int n) {
        if(p.length() == n * 2) {
            res.add(p);
            return;
        }
        if(left < n)
            recursive(left + 1, right, p + "(", res, n);
        if(right < left)
            recursive(left, right + 1, p + ")", res, n);
    }

    public static void main(String[] args) {
        var res = new Solution().generateParenthesis(2);
        System.out.println(res);
    }
}