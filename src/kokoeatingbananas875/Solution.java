package kokoeatingbananas875;

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var max = Arrays.stream(piles).max().orElseThrow();
        var arr = new int [max];
        for(int i = 0 ; i< max ; i++){
            arr[i] = i + 1;
        }
        int i = 0, j = max - 1;
        while(i <= j){
            var mid = i + (j - i) / 2;
            var target = arr[mid];
            var cnt = 0;
            for(var pile:piles){
                var targetPile = pile % target == 0 ? pile / target : (pile / target) + 1;
                cnt += targetPile;
            }
            if(cnt == h){
                return target;
            }
            if(cnt > h){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var x = new Solution().minEatingSpeed(new int[]{3,6,7,11}, 8);
        System.out.println(x);
    }
}