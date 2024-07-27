package defusethebomb1652;

import java.util.Arrays;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if(k == 0)
            return new int[k];
        if(k > 0)
            return decryptCaseOne(code,k, n);
        return decryptCaseTwo(code,k, n);

    }
    public int[] decryptCaseOne(int[] code, int k, int n) {
        int[] res = new int[n];
        int window = 0;
        for(int i=0; i< k; i++){
            window += code[i];
        }
        int l = 0;
        int r = k;
        for(int i=0;i<n;i++){
            window -= code[l % n];
            window += code[r % n];
            l++;r++;
            res[i] = window;
        }
        return res;
    }
    public int[] decryptCaseTwo(int[] code, int k, int n) {
        k = k * -1;
        int [] res = decryptCaseOne(reverse(code, n), k , n) ;
        return reverse(res, n);
    }
    private int[] reverse(int[] code, int n){
        int i = 0;
        int j = n - 1;
        int[] reversed = new int[n];
        while(i < n){
            reversed[i++] = code[j--];
        }
        return reversed;
    }

    public static void main(String[] args) {
        var x = new Solution().decrypt(new int[]{5,7,1,4}, 3);
        Arrays.stream(x).forEach(System.out::println);
    }
}