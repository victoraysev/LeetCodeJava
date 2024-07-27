package mergesortedarray88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var i = 0;
        var j = 0;
        while(j < n){
            if(i >= m){

                nums1[i] = nums2[j];
                i++;
                j++;
            }
            else if (nums1[i] <= nums2[j]){
                i++;
            }
            else{
                shift(nums1, i);
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }
        }
    }

    private void shift(int[] nums, int i) {
        for (int j = nums.length - 1; j > i ; j--) {
            nums[j] = nums[j - 1];
            nums[j - 1] = 0;
        }
    }

    public static void main(String[] args) {
        var x = new int[]{1,2,3,0,0,0};
        new Solution().merge(x, 3, new int[]{2,5,6}, 3);
        System.out.println("end");
    }
}