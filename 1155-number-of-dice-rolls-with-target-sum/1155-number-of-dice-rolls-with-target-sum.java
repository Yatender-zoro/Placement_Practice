class Solution {
    static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return solve(n, k, target, dp);
    }

    int solve(int dice, int k, int target, Integer[][] dp){
        if(dice==0) return target==0 ? 1 : 0;
        if(target<0) return 0;

        if(dp[dice][target]!=null) return dp[dice][target];

        long ways = 0;
        for(int face=1; face<=k; face++){
            ways += solve(dice-1, k, target-face, dp);
            ways %= MOD;
        }
        return dp[dice][target] = (int)ways;
    }
}
