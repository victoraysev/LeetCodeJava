package validpalindrome125;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return helper(s);
    }

    private boolean helper(String s) {
        if(s.length() <= 1)
            return true;
        if(s.length() == 2)
            return s.charAt(0) == s.charAt(1);
        return s.charAt(0) == s.charAt(s.length() - 1) && helper(s.substring(1,s.length() - 1));
    }

    public static void main(String[] args) {
        var x =new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("end");
    }

}
