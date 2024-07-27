package findtheindexofoccurence28;

import java.util.Arrays;

public class Solution {
    public int strStr(String haystack, String needle) {
        var i = 0;
        var character = needle.charAt(i);
        var arr = haystack.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            var searchCharacter = arr[j];
            if(searchCharacter == character){
                if(i == needle.length() - 1){
                    return j - i;
                }
                i++;
            }
            else{
                j = j - i;
                i = 0;
            }
            character = needle.charAt(i);
        }
        return -1;
    }

    public static void main(String[] args) {
//        var haystack = "aabutsad";
//        var needle = "sad";
//        var haystack = "leetcode";
//        var needle = "leeto";
        var haystack = "mississipi";
        var needle = "issip";
        var res = new Solution().strStr(haystack, needle);
        System.out.println(res);
    }
}
