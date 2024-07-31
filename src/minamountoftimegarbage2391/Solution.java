package minamountoftimegarbage2391;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int [] arr = new int[travel.length + 1];
        arr[0] = 0;
        var i =1;
        for(var travelNum:travel){
            arr[i] += arr[i - 1] + travelNum;
            i++;
        }
        res+=garbageCollection(garbage,arr,'M');
        res+=garbageCollection(garbage,arr,'P');
        res+=garbageCollection(garbage,arr,'G');
        return res;

    }
    public int garbageCollection(String[] garbage, int[] travel, char c_){
        var i = 0;
        var totalCost = 0;
        int maxIndex = -1;
        for(var x:garbage){
            int cost = 0;
            for(var c:x.toCharArray()){
                if(c == c_)
                    cost++;
            }
            if(cost > 0){
                totalCost +=  cost;
                maxIndex = i;
            }
            i++;
        }
        int travelCost = maxIndex == -1? 0 : travel[maxIndex];

        return totalCost + travelCost;

    }

    public static void main(String[] args) {
        var x = new Solution().garbageCollection(new String[]{"G","P","GP","GG"},new int[]{2,4,3});
        System.out.println(x);
    }
}