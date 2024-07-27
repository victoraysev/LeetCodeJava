package excelsheetcolumnnumber171;

public class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        double pow = 0;
        for (int i = columnTitle.length() - 1; i >= 0 ; i--) {
            char c = columnTitle.charAt(i);
            num += (c - 'A' + 1) * Math.pow(26, pow++);
        }
        return num;
    }

    public static void main(String[] args) {
        var res = new Solution().titleToNumber("ZY");
        System.out.println(res);
    }
}
