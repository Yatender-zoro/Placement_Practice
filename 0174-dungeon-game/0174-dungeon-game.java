class Solution {
    
    public int calculateMinimumHP(int[][] d) {
        int m = d.length;
        int n = d[0].length;
        int[][] dp = new int[m][n];

         dp[m-1][n-1] = Math.min(0, d[m-1][n-1]);

        for(int i=n-2;i>=0;i--){
            int val = dp[m-1][i+1] + d[m-1][i];
            if(val<0) dp[m-1][i] = val;
            else dp[m-1][i] = 0;
        }

        for(int i=m-2;i>=0;i--){
            int val = dp[i+1][n-1] + d[i][n-1];
             if(val<0) dp[i][n-1] = val;
            else dp[i][n-1] = 0;
        }

        for(int i = m-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]) + d[i][j];
                if(dp[i][j]>0) dp[i][j] = 0;
            }
        }

        return -dp[0][0] + 1;
    }
    
}