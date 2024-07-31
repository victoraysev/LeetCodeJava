package threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(nums);
        var i = 0;
        while(i < nums.length - 2){
            var a = nums[i];
            var j = i + 1;
            var k = nums.length - 1;
            while(j < k){
                if( a + nums[j] + nums[k] == 0){
                    r.add(Arrays.asList(a, nums[j], nums[k]));
                    j++;
                    while(nums[j - 1] == nums[j] && j < nums.length - 1){
                        j++;
                    }
                    while(nums[k - 1] == nums[k] && k > 1){
                        k--;
                    }
                }
                else if(a + nums[j] + nums[k] > 0){
                    k--;
                }
                else if(a + nums[j] + nums[k] < 0){
                    j++;
                }
            }
            i++;
            while(nums[i - 1] == nums[i] && i < nums.length - 2){
                i++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        var x = new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(x);
    }
}