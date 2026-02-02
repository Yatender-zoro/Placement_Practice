class Solution {
    // int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();

        // bottom up 


        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++) dp[i][i] = 0;

        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j = i+l-1;

                if(s.charAt(i)==s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][n-1];
        // dp = new int[n][n];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return solve(0,n-1,s);
    }
    // public int solve(int i,int j,String s){
    //     if(i>j) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s.charAt(i)==s.charAt(j)){
    //         return dp[i][j] = solve(i+1,j-1,s);
    //     }

    //     return dp[i][j] = 1 + Math.min(solve(i+1,j,s),solve(i,j-1,s));
    // }
}