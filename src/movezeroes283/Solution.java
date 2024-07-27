package movezeroes283;

public class Solution {
    public void moveZeroes(int[] nums) {
        var i = 0;
        var j = 0;
        var len = nums.length - 1;
        while (i < len) {
            if (nums[i] != 0) {
                i++;
            } else {
                j = i + 1;
                while (j < len && nums[j] == 0) {
                    j++;
                }
                swap(nums, i , j);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        var x = new int[] {0,1,0,3,12};
        new Solution().moveZeroes(x);
        System.out.println("x");
    }

}
