package largestlocalmatrix2373;

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int nNew = n - 3 + 1;
        int res [][] = new int [nNew][nNew];
        for(int i2 = 0; i2 < nNew; i2++){
            for(int j2 = 0; j2 < nNew; j2++){
                int max = -1;
                for(int i = i2; i < i2 + 3 ; i++){
                    for(int j = j2; j < j2 + 3; j++){
                        max = Math.max(max, grid[i][j]);
                    }
                }
                res[i2][j2] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}});
    }
}
 