class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int m = t1.length();
        int n = t2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
//     int m,n;
//     int[][] dp;
//     public int longestCommonSubsequence(String t1, String t2) {
//         this.m = t1.length();
//         this.n = t2.length();
//         dp = new int[m][n];
//         for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
//         return solve(t1,t2,0,0);
//     }

//     public int solve(String t1,String t2,int i,int j){
//         if(i>=m) return 0;
//         if(j>=n) return 0;

//         if(dp[i][j]!=-1) return dp[i][j];
//         if(t1.charAt(i)==t2.charAt(j)){
//             return dp[i][j] = 1+solve(t1,t2,i+1,j+1);
//         }
             
//         return dp[i][j] = Math.max(solve(t1,t2,i+1,j),solve(t1,t2,i,j+1));

//     }
// }