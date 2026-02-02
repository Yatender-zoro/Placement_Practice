class Solution {
    static final int MOD = 1_000_000_007;
    public int countHousePlacements(int n) {
        
        if(n==1) return 4;
        if(n==2) return 9;

        long[] dp = new  long[n+1];
        dp[1] = 2;
        dp[2] = 3;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%MOD;
        }
        return (int)(dp[n]*dp[n]%MOD);
    }
}