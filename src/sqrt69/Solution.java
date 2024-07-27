package sqrt69;

class Solution {
    public int mySqrt(int x) {
        for (int i = 0; i <= x/2; i++) {
            var res = (long)i * (long)i;
            if (res > x)
                return i - 1;
            else if (i * i == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        var res = new Solution().mySqrt(2147483647);
        System.out.println(res);
    }
}