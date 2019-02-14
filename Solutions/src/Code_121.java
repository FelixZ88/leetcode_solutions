public class Code_121 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = 0;
        int profit = prices[max] - prices[min];

        for(int i = 1; i < prices.length; i ++) {
            int price = prices[i];
            if (price > prices[max]) {
                max = i;
                int profit2 = price - prices[min];
                if (profit < profit2) {
                    profit = profit2;
                }
            } else if (price < prices[min]) {
                min = i;
                max = i;
            }
        }
        return profit;
    }
}
