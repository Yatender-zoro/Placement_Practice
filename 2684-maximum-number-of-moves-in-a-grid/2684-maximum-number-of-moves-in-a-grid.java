class Solution {
    int[][]dp;
    public int maxMoves(int[][] grid) {
        int m = 0;
        dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<grid.length;i++){
            m = Math.max(m,solve(i,0,grid));
        }
        return m;
    }

    public int solve(int i,int j,int[][] grid){
        
        int ur = 0;
        int r = 0;
        int dr = 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(i-1>=0 && j+1<grid[0].length && grid[i][j]<grid[i-1][j+1])
            ur = 1 + solve(i-1,j+1,grid);
        if(i>=0 && i<grid.length && j+1<grid[0].length && grid[i][j]<grid[i][j+1])
            r = 1+ solve(i,j+1,grid);
        if(i+1<grid.length && j+1<grid[0].length && grid[i][j]<grid[i+1][j+1])
            dr = 1+ solve(i+1,j+1,grid);
        
        return dp[i][j] = Math.max(ur,Math.max(r,dr));
    }
}