class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    DFS(i, j, vis, grid, n,q);
                    break outer;
                }
            }
        }

        int level = 0;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || vis[ni][nj])
                        continue;

                    if (grid[ni][nj] == 1)
                        return level;

                    vis[ni][nj] = true;
                    q.add(new int[] { ni, nj });
                }
            }
            level++;
        }
        return -1;

    }

    void DFS(int i, int j, boolean[][] vis, int[][] grid, int n, Queue<int[]> q) {

        if (i < 0 || i >= n || j < 0 || j >= n || vis[i][j] || grid[i][j] == 0)
            return;

        vis[i][j] = true;
        q.add(new int[] { i, j });

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        for (int k = 0; k < 4; k++) {
            DFS(i + dx[k], j + dy[k], vis, grid, n, q);
        }
    }
}