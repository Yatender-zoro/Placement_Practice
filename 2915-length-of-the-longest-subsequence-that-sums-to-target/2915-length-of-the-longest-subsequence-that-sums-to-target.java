class Solution {
    //int[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                if (dp[t - num] != Integer.MIN_VALUE) {
                    dp[t] = Math.max(dp[t], dp[t - num] + 1);
                }
            }
        }

        return dp[target] <= 0 ? -1 : dp[target];
        
        // Collections.sort(nums);
        // dp = new int[nums.size()][target+1];
        // for(int i=0;i<nums.size();i++) Arrays.fill(dp[i],-1);
        // int r = solve(0,nums,target);
        // return r<=0?-1:r;
    }

    // public int solve(int idx,List<Integer> nums, int target){
    //     if(target<=0 || idx>=nums.size()){
    //         return Integer.MIN_VALUE;
    //     }
    //     if(target==nums.get(idx)){
    //         return 1;
    //     }

    //     if(dp[idx][target]!=-1) return dp[idx][target];
    //     int take = Integer.MIN_VALUE;
    //     if(target-nums.get(idx)<0) return take;
    //     take = 1 + solve(idx+1,nums,target-nums.get(idx));
    //     int skip = solve(idx+1,nums,target);

    //     return dp[idx][target] = Math.max(take,skip);
    // }
}