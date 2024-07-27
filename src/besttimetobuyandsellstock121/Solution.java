package besttimetobuyandsellstock121;

public class Solution {
    public int maxProfit(int[] prices) {
        int minIndex = prices.length,profit = 0;
        do {
            var profitAndMinIndex = getProfit(prices, minIndex);
            minIndex = profitAndMinIndex[0];
            if(profitAndMinIndex[1] > profit)
                profit = profitAndMinIndex[1];
        } while (minIndex > 0);
        return profit;
    }

    public int[] getProfit(int[] prices, int j) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < j; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
        }
        for (int i = minIndex + 1; i < j; i++) {
            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return new int[]{minIndex, profit};
    }

    public static void main(String[] args) {
        var res = new Solution().maxProfit(new int[] {20,2,4,1,3,10});
        System.out.println(res);
    }
}
