package xofakind914;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = deck.length;
        for(int i=0; i< n;i++){
            map.merge(deck[i],1,Integer::sum);
        }
        var x = map.values();
        var min = Collections.min(x);
        var res = 1;
        for(int cnt=2;cnt<=min;cnt++){
            boolean check =true;
            for(int xVal:x){
                if(xVal % cnt != 0){
                    check = false;
                    break;
                }
            }
            if(check)
                res = cnt;
        }
        return res != 1;
    }

    public static void main(String[] args) {
        var x = new Solution().hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1});
        System.out.println(x);
    }
}