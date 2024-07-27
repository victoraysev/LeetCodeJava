package kthsmallestelementinasortedmatrix378;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int i = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int j = 0; j < matrix.length; j++) {
            indexMap.put(j, 0);
        }
        while (i < arr.length) {
            arr[i++] = getMin(matrix, indexMap);
        }
        return arr[k - 1];
    }

    private int getMin(int[][] matrix, Map<Integer, Integer> indexMap) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            if(indexMap.get(i) < matrix[0].length && matrix[i][indexMap.get(i)] < min){
                min = matrix[i][indexMap.get(i)];
                minIndex = i;
            }
        }
        indexMap.put(minIndex,indexMap.get(minIndex) + 1);
        return min;
    }

//    public static void main(String[] args) {
//
//        Solution solution = new Solution();
//        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
//        int k = 8;
//        System.out.println(solution.kthSmallest(matrix, k));
//    }
}
