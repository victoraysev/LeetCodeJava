package arraybreakhackerrank;

import java.util.List;

public class Solution {
    public static int perfectBreak(List<Integer> list) {
        int[] b = new int[list.size()];
        int[] c = new int[list.size()];
        return perfectBreak(list, b, c, 0);
    }

    private static int perfectBreak(List<Integer> list, int[] b, int[] c, int i) {
        // If we have processed all elements
        if (i == list.size()) {
            return 1;
        }

        int totalWays = 0;

        for (int j = 0; j <= list.get(i); j++) {
            b[i] = j;
            c[i] = list.get(i) - j;

            // Check ascending order for b and descending order for c
            if ((i == 0 || b[i - 1] <= b[i]) && (i == 0 || c[i - 1] >= c[i])) {
                totalWays += perfectBreak(list, b, c, i + 1);
            }
        }

        return totalWays;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 2);
        System.out.println(perfectBreak(list));
    }
}
