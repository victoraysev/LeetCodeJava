package minrecolors2379;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int min = 0;
        int i = 0;
        int j = i + k - 1;
        for(int l = i; l <= j; l++){
            if(blocks.charAt(l) == 'W'){
                min++;
            }
        }
        int localMin = min;
        while(j < n - 1){
            String subs = blocks.substring(i,j);
            if(blocks.charAt(i) == 'W'){
                localMin -= 1;
            }
            i++;
            j++;
            if(blocks.charAt(j) == 'W'){
                localMin += 1;
            }
            min = Math.min(localMin, min);
        }
        return min;
    }

    public static void main(String[] args) {
        var x = new Solution().minimumRecolors("BWBBWWBBBWBWWWBWWBBWBWBBWBB", 11);
        System.out.println(x);
    }
}