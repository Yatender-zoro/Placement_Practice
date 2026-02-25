import java.util.*;

class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return solve(0, 1, prices);
    }

    int solve(int idx, int canBuy, int[] prices) {
        if (idx >= prices.length) return 0;

        if (dp[idx][canBuy] != null)
            return dp[idx][canBuy];

        if (canBuy == 1) {
            int buy = -prices[idx] + solve(idx + 1, 0, prices);
            int skip = solve(idx + 1, 1, prices);
            return dp[idx][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + solve(idx + 2, 1, prices);
            int hold = solve(idx + 1, 0, prices);
            return dp[idx][canBuy] = Math.max(sell, hold);
        }
    }
}