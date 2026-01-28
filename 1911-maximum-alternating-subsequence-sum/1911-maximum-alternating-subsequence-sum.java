class Solution {
     Long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new Long[n+1][2];
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0l;
            dp[i][1] = 0l;
        }
        
         for(int i=1;i<=n;i++){
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1],dp[i-1][1]);
         }
         return Math.max(dp[n][1],dp[n][0]);
        // return solve(nums,0,0);
    }

    // public long solve(int[] nums,int idx,int c){
    //     if(idx==nums.length) return 0;

    //      if (dp[idx][c] != null) return dp[idx][c];
    //     // skip
    //     long skip = solve(nums,idx+1,c);

    //     // take
    //     long take = solve(nums,idx+1,1 - c)+ (c%2==0?nums[idx]:-nums[idx]);
    //     return dp[idx][c] = Math.max(skip, take);
    // }
}