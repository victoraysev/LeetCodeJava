package longestcommonprefix14;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","doge","dogedoge"}));
        System.out.println(longestCommonPrefix(new String[]{"reflower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String minStr = Arrays.stream(strs).
                min(Comparator.comparingInt(String::length))
                .orElse("");
        for (String str : strs) {
            while (!(str.startsWith(minStr))){
                minStr = minStr.substring(0, minStr.length() - 1);
            }
        }
        return minStr;
    }
}
