package furthestbuildingyoucanreach1642;

import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if(diff > 0){
                q.add(diff);
            }
            if(q.size() > ladders){
                int numberOfBricks = q.remove();
                bricks -= numberOfBricks;
                if(bricks < 0){
                    return i;
                }
            }
        }
        return heights.length - 1;


    }

    public static void main(String[] args) {
        new Solution().furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19},10, 2);
    }
}
