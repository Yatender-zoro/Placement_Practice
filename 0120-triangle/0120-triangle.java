class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        return solve(0,0,t);
    }
    public int solve(int i,int j,List<List<Integer>> t){
        if(i>=t.size()) return 0;
        if(j>=t.get(i).size()) return 0;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        return dp[i][j] = t.get(i).get(j) + Math.min(solve(i+1,j,t),solve(i+1,j+1,t));
    }
}