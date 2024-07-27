package plusone66;

class Solution {
    public int[] plusOne(int[] digits) {
        var n = digits.length;
        var lastDigit = digits[n - 1];
        if(lastDigit != 9){
            digits[n - 1] = lastDigit + 1;
            return digits;
        }
        var i = 1;
        do {
            digits[n - i] = 0;
            try {
                digits[n - i - 1] = digits[n - i - 1] + 1;
                i++;
            }catch (IndexOutOfBoundsException e){
                var digitsClone = new int[n + 1];
                digitsClone[0] = 1;
                for (int j = 1; j < n + 1; j++) {
                    digitsClone[j] = digits[j - 1];
                    digits = digitsClone;
                }
            }
        }while(digits[n - i] == 10);
        return digits;
    }

    public static void main(String[] args) {
        var res = new Solution().plusOne(new int[]{9,9,9});
        for (var elem :
                res) {
            System.out.print(elem + " ");
        }
    }
}