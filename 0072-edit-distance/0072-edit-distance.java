class Solution {
    int[][] dp;
    int n,m;
    public int minDistance(String w1, String w2) {
        this.n = w1.length();
        this.m = w2.length();
        dp = new int[n][m];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(n-1,m-1,w1,w2);
    }

    public int solve(int n, int m ,String w1, String w2){
        if(n < 0) return m + 1;
        if(m < 0) return n + 1;

        if(w1.charAt(n)==w2.charAt(m)){
            return solve(n-1,m-1,w1,w2);
        }
        
        if(dp[n][m]!=-1) return dp[n][m];

        int del = 1 + solve(n-1,m,w1,w2);

        int insert = 1 + solve(n,m-1,w1,w2);
        int replace = 1 + solve(n-1,m-1,w1,w2);

        int mini = Math.min(del,insert);
        return dp[n][m] = Math.min(mini,replace);
    }
}