package permutations46;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recursive(nums, result, permutation, used);
        return result;
    }
    public void recursive(int[] nums, List<List<Integer>> result, List<Integer> permutation , boolean[] used ){
        if(permutation.size() == nums.length){
            result.add(permutation);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                permutation.add(nums[i]);
                recursive(nums, result, permutation, used);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permute(new int[]{1,2,3});
    }
}
