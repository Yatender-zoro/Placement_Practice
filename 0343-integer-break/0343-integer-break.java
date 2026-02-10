class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    public int solve(int n){
        if(n==1) return 1;

        if(dp[n]!=-1) return dp[n];
        int r = 0;
        for(int i=1;i<n;i++){
            int p = i * Math.max(n-i,solve(n-i));
            r  = Math.max(r,p);
        }
        return dp[n] = r;
    }
}