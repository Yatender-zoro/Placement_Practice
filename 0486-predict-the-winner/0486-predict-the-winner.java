class Solution {
    public boolean predictTheWinner(int[] nums) {

        // !  1st
        // int sum = 0;
        // for(int x:nums) sum+=x;

        // int score = solve(0,nums.length-1,nums);

        // return score>=sum/2 ;

        Integer[][]dp = new Integer[21][21];
        return solve(0,nums.length-1,nums,dp)>=0;
    }

    int solve(int i,int j,int[] nums,Integer[][] dp){

        //  // 1st APPROACH
        // if(i>j) return 0;

        // if(i==j) return nums[i];
        
        // int f = nums[i] + Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        // int s = nums[j] + Math.min(solve(i,j-2,nums),solve(i+1,j-1,nums));
        
       
        // return Math.max(f,s);

        if(i>j) return 0;
        if(i==j) return nums[i];

        if(dp[i][j]!=null ) return dp[i][j];

        int f = nums[i] - solve(i+1,j,nums,dp);
        int s = nums[j] - solve(i,j-1,nums,dp);

        return dp[i][j] = Math.max(f,s);    }
}