class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
       this.n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
       
        int result = solve(n-1,coins,amount);
        return result==Integer.MAX_VALUE?0:result;
    }
    public int solve(int idx,int[] coins,int amount){
        if(amount==0){
            return 1;
        }
        if(amount<0 || idx<0) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        return dp[idx][amount] = solve(idx,coins,amount-coins[idx])+solve(idx-1,coins,amount);
    }
   
}