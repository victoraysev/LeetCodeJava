package getmaxpalindromesubstringhackerrank;

public class Solution {

    public static int getMaxSubstring ( String s, int k){

        int max = 0;
        for(int i = 0; i < s.length(); i++){
            max = Math.max(max, getMaxSubstring(s, k, i));
        }
        return max;
    }
    private static int getMaxSubstring(String s, int k, int i){
        return -1;
    }
    private static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
