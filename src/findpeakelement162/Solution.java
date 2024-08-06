package findpeakelement162;

class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i <  j){
            int mid = i + (j - i) / 2;
            var midVal = nums[mid];
            if(mid < nums.length - 1 && midVal < nums[mid + 1]){
                i = mid + 1;
            }
            else if (mid > 0 && midVal < nums[mid - 1]){
                j = mid - 1;
            }
            else{
                return midVal;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var x = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(x.findPeakElement(nums));
    }
}