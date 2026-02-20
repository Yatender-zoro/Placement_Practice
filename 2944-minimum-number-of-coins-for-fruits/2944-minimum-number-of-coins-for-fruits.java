class Solution {
    
    //Integer[][] dp;
    public int minimumCoins(int[] prices) {

         int n = prices.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int maxReach = Math.min(n, i + i + 2);
            for (int j = i + 1; j <= maxReach; j++) {
                dp[i] = Math.min(dp[i], prices[i] + dp[j]);
            }
        }

        return dp[0];
        
        // dp = new Integer[prices.length+1][prices.length+1];
        // return solve(0,prices,0);

        // int n = prices.length;
        // int[][] dp = new int[n+1][n+1];

        // for(int idx=n-1; idx>=0; idx--){
        //     for(int limit=0; limit<=n; limit++){

        //         int free = Integer.MAX_VALUE/2;
        //         if(limit > 0)
        //             free = dp[idx+1][limit-1];

        //         int paid = prices[idx] + dp[idx+1][idx+1];

        //         dp[idx][limit] = Math.min(free, paid);
        //     }
        // }
        // return dp[0][0];
        
    }

    // int solve(int idx,int[] prices,int limit){
    //     if(idx==prices.length){
            
    //         return 0;
    //     }

    //     if(dp[idx][limit]!=null) return dp[idx][limit];

    //     int free = Integer.MAX_VALUE/2;
    //     if(limit >0){         
    //         free = solve(idx+1,prices,limit-1); 
    //     }
    //     int paid = prices[idx] + solve(idx+1,prices,idx+1);

    //     return dp[idx][limit] = Math.min(paid,free);
    // }
}