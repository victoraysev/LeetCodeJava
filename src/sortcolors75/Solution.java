package sortcolors75;

public class Solution {
    public void sortColors(int[] nums) {
        int[] numCounts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                numCounts[0]++;
            } else if (nums[i] == 1) {
                numCounts[1]++;
            } else {
                numCounts[2]++;
            }
        }
        int index = 0;
        for (int i = 0; i < numCounts[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < numCounts[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < numCounts[2]; i++) {
            nums[index++] = 2;
        }
    }
}
