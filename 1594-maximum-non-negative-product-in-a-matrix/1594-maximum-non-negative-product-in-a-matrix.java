class Solution {
    int m, n;
    Pair[][] dp;
    static class Pair {
        long max, min;
        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Pair[m][n];

        
        Pair ans = solve(0, 0, grid);

        long MOD = 1_000_000_007;

        if (ans.max < 0) return -1;
        return (int)(ans.max % MOD);
    }

    public Pair solve(int i, int j, int[][] grid) {

        if (i == m - 1 && j == n - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if(dp[i][j]!= null) return dp[i][j];
        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        
        if (i + 1 < m) {
            Pair down = solve(i + 1, j, grid);

            long a = grid[i][j] * down.max;
            long b = grid[i][j] * down.min;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        
        if (j + 1 < n) {
            Pair right = solve(i, j + 1, grid);

            long a = grid[i][j] * right.max;
            long b = grid[i][j] * right.min;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        return dp[i][j] = new Pair(maxVal, minVal);
    }
}
