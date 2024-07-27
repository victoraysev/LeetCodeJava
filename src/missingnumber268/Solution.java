package missingnumber268;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int sumGiven = 0;
        for(int i = 0; i < nums.length; i++){
            sum += i + 1;
            sumGiven += nums[i];
        }
        return sum- sumGiven;
    }
}
