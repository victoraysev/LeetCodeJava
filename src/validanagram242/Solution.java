package validanagram242;


public class Solution {
    public boolean isAnagram(String s, String t){
        while(s.length() != 0 || t.length() != 0){
            if(s.length() != t.length())
                return false;
            char sC = s.charAt(0);
            s = s.replaceAll(sC+"","");
            t = t.replaceAll(sC+"","");
        }
        return true;
    }

    public static void main(String[] args) {
        var res = new Solution().isAnagram("rat", "car");
        System.out.println(res);
    }
}
