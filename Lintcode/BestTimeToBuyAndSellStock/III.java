public class III {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        
        int[] maxleft = new int[n];
        int[] maxright = new int[n];
        int min = prices[0];
        
        for (int i = 1; i < n; i++) {
            maxleft[i] = Math.max(maxleft[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        int max = prices[n - 1];
        for (int i = n - 2; i >= 2; i--) {
            maxright[i] = Math.max(maxright[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        int ans = 0;
        for (int i = 1; i <= n - 3; i++) {
            ans = Math.max(ans, maxleft[i] + maxright[i + 1]);
        }
        
        return Math.max(ans, maxleft[n-1]);
    }
};
