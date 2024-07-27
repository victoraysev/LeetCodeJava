package longestevenoddsubarraywiththreshold2760;

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        if (nums.length <= 0)
            return 0;
        if (nums.length == 1)
            return nums[0] % 2 == 0 && nums[0] <= threshold ? 1:0;
        int max = 0;
        int l = 0;
        while (l < nums.length) {
            if (nums[l] % 2 == 0 && nums[l] <= threshold) {
                int r = l + 1;
                boolean odd = true;
                if(r == nums.length){
                    max = Math.max(max, r - l);
                }
                while (r < nums.length && ((odd && nums[r] % 2 == 1) || (!odd && nums[r] % 2 == 0)) && nums[r] <= threshold) {
                    odd = !odd;
                    r++;
                    max = Math.max(max, r - l);
                }
            }
            l++;
        }
        return max;
    }

    public static void main(String[] args) {
        var x = new Solution().longestAlternatingSubarray(new int[]{2,5}, 2);
        System.out.println(x);
    }
}