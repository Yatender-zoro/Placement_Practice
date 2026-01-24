class Solution {
    int[][] dp;
    int m, n, target;
    public int minimizeTheDifference(int[][] mat, int target) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.target = target;

        dp = new int[m][5001];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);

        return dfs(0, 0, mat);
    }
    int dfs(int row, int sum, int[][] mat) {
        if (row == mat.length) {
            return Math.abs(sum - target);
        }
        if (dp[row][sum] != -1) return dp[row][sum];

        int res = Integer.MAX_VALUE;
        for (int col = 0; col < mat[0].length; col++) {
            res = Math.min(res, dfs(row + 1, sum + mat[row][col], mat));
        }
        return dp[row][sum] = res;
    }
}