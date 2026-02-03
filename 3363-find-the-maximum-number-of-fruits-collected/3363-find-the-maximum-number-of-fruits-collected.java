class Solution {
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) {
        int sum =0;
        this.n = fruits.length;
        for(int i=0;i<n;i++){
            sum+=fruits[i][i];
            fruits[i][i] = 0;
        }

        dp = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
            dp[i][i] = 0;
        }
        // solve for child 2 and 3 

        sum+=solve1(0,n-1,fruits) + solve2(n-1,0,fruits);
        return sum;
    }

    public int solve1(int i, int j, int[][] fruits){
        if(i<0 || i>=n || j<0 || j>=n) return Integer.MIN_VALUE;
        if(i==n-1 && j==n-1) return 0;
        if(i>j) return Integer.MIN_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];
        int left = solve1(i+1,j-1,fruits);
        int down = solve1(i+1,j,fruits);
        int right = solve1(i+1,j+1,fruits);
        return dp[i][j] = fruits[i][j] + Math.max(left,Math.max(down,right));
    }

    public int solve2(int i, int j, int[][] fruits){
        if(i<0 || i>=n || j<0 || j>=n) return 0;
        if(i==n-1 && j==n-1) return Integer.MIN_VALUE;
        if(i<j) return Integer.MIN_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int dndiag = solve2(i+1,j+1,fruits);
        int updiag = solve2(i-1,j+1,fruits);
        int right = solve2(i,j+1,fruits);
        return dp[i][j] = fruits[i][j] + Math.max(dndiag,Math.max(updiag,right));
    }
}