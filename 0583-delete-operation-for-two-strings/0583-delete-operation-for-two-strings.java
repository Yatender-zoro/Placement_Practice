class Solution {
    //int[][]dp;
    public int minDistance(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0; // dp[i-1][j-1]
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (w1.charAt(i - 1) == w2.charAt(j - 1))
                    dp[j] = 1 + prev;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = temp;
            }
        }

        int lcs = dp[m];
        return (n - lcs) + (m - lcs);
        // dp = new int[w1.length()][w2.length()];

        // for(int i=0;i<w1.length();i++) Arrays.fill(dp[i],-1);
        // return solve(0,0,w1,w2);
    }

    // public int solve(int i,int j,String w1,String w2){
    //     if(i==w1.length() || j==w2.length()){
    //         return w1.length()-i + w2.length()-j; 
    //     }
        
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(w1.charAt(i)==w2.charAt(j)){
    //         return dp[i][j] = solve(i+1,j+1,w1,w2);
            
    //     }
        
    //     return dp[i][j] = 1 + Math.min(solve(i+1,j,w1,w2),solve(i,j+1,w1,w2));
    // }
}