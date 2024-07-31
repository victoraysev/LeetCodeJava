package uglynumber263;

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false; // Ugly numbers are positive integers

        // Divide the number by 2, 3, and 5 as long as it's divisible
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        // If we are left with 1, then the number is an ugly number
        return n == 1;
    }
}
