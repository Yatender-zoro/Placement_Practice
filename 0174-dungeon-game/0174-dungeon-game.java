class Solution {
    int m,n;
    int[][] dp;
    public int solve(int i,int j, int[][] d){

        if(i>=m || j>=n) return Integer.MAX_VALUE;

        if(i==m-1 && j==n-1){
            if(d[i][j]>0) return 1;
            return -d[i][j] + 1; 
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int right = solve(i,j+1,d);
        int down = solve(i+1,j,d);

        int result = Math.min(right,down) - d[i][j];

        return dp[i][j] = result = ( result > 0 ? result : 1);
    }

    public int calculateMinimumHP(int[][] d) {

        this.m = d.length;
        this.n = d[0].length;
        dp = new int[m][n];

        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return solve(0,0,d);
        // int m = d.length;
        // int n = d[0].length;
        // int[][] dp = new int[m][n];

        //  dp[m-1][n-1] = Math.min(0, d[m-1][n-1]);

        // for(int i=n-2;i>=0;i--){
        //     int val = dp[m-1][i+1] + d[m-1][i];
        //     if(val<0) dp[m-1][i] = val;
        //     else dp[m-1][i] = 0;
        // }

        // for(int i=m-2;i>=0;i--){
        //     int val = dp[i+1][n-1] + d[i][n-1];
        //      if(val<0) dp[i][n-1] = val;
        //     else dp[i][n-1] = 0;
        // }

        // for(int i = m-2;i>=0;i--){
        //     for(int j = n-2;j>=0;j--){
        //         dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]) + d[i][j];
        //         if(dp[i][j]>0) dp[i][j] = 0;
        //     }
        // }

        // return -dp[0][0] + 1;
    }
    
}