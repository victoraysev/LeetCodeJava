package climbingstairs70;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> map;
    private int climbingStairsRecursive(int sum, int target){
        if(sum == target / 2)
            return 1;
        if(sum > target)
            return 0;
        var plusone = -1;
        if(map.get(sum + 1) == null) {
            plusone = climbingStairsRecursive(sum + 1, target);
            map.put(sum + 1, plusone);
        }
        else{
            plusone = map.get(sum + 1);
        }
        var plustwo = -1;
        if(map.get(sum + 2) == null) {
            plustwo = climbingStairsRecursive(sum + 2, target);
            map.put(sum + 2, plustwo);
        }
        else{
            plustwo = map.get(sum + 2);
        }

        return plusone + plustwo;
    }
    public int climbStairs(int n) {
        map = new HashMap<>();
        var result =  climbingStairsRecursive(0, n);
        return result;
    }

    public static void main(String[] args) {
        var result = new Solution().climbStairs(45);
        System.out.println(result);
    }
}

//1134903170