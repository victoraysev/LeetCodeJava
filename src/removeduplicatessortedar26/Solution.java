package removeduplicatessortedar26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0 ; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]){
                int cnt = nums[i];
                for (int j = i + 2; j < nums.length ; j++) {
                    if(nums[j] != cnt){
                        nums[i+1] = nums[j];;
                        break;
                    }
                }
            }
            else{
                k++;
            }
        }
        return k;
    }
}