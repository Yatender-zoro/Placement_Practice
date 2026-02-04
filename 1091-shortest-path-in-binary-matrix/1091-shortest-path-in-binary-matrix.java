// class Pair{
//     int[] pos;
//     int val;

//     Pair(int[] pos,int val){
//         this.pos = pos;
//         this.val = val;
//     }
// }

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0, 1}); 
        vis[0][0] = true;

         while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == n-1 && y == n-1) return dist;

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                    !vis[nx][ny] && grid[nx][ny] == 0) {

                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
        // int  n = grid.length;
        // Queue<Pair> q = new LinkedList<>();
        // q.add(new Pair(new int[]{0,0},1));

        // boolean vis[][] = new boolean[n][n];
        // vis[0][0] = true;
        
        // if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // while(!q.isEmpty()){
        //     Pair ele = q.poll();
        //     int i = ele.pos[0];
        //     int j = ele.pos[1];
        //     int val = ele.val;
            
        //     if(i==n-1 && j==n-1){
        //         return val;
        //     }
        //     else{
               
        //         //up-left
        //         if(i-1>=0 && j-1>=0 && vis[i-1][j-1]==false && grid[i-1][j-1] == 0){
        //             vis[i-1][j-1] = true;
        //             q.add(new Pair(new int[]{i-1,j-1},val+1));
        //         }

        //         // up 
        //         if(i-1>=0 && j>=0 && vis[i-1][j]==false && grid[i-1][j] == 0){
        //             vis[i-1][j] = true;
        //             q.add(new Pair(new int[]{i-1,j},val+1));
        //         }

        //         // up right
        //         if(i-1>=0 && i<n && j+1<n && vis[i-1][j+1]==false && grid[i-1][j+1] == 0){
        //             vis[i-1][j+1] = true;
        //             q.add(new Pair(new int[]{i-1,j+1},val+1));
        //         }

        //         // right 
        //         if(i>=0 && i<n && j+1<n && vis[i][j+1]==false && grid[i][j+1] == 0){
        //             vis[i][j+1] = true;
        //             q.add(new Pair(new int[]{i,j+1},val+1));
        //         }

        //         // down right
        //         if(i+1<n && j+1<n && vis[i+1][j+1]==false && grid[i+1][j+1] == 0){
        //             vis[i+1][j+1] = true;
        //             q.add(new Pair(new int[]{i+1,j+1},val+1));
        //         }
        //         // down
        //         if(i+1<n && j<n && j>=0 && vis[i+1][j]==false && grid[i+1][j] == 0){
        //             vis[i+1][j] = true;
        //             q.add(new Pair(new int[]{i+1,j},val+1));
        //         }

        //         // down left
        //         if(i+1<n  && j-1>=0 && vis[i+1][j-1]==false && grid[i+1][j-1] == 0){
        //             vis[i+1][j-1] = true;
        //             q.add(new Pair(new int[]{i+1,j-1},val+1));
        //         }

        //         // left
        //         if(i>=0 && i<n && j-1>=0 && vis[i][j-1]==false && grid[i][j-1] == 0){
        //             vis[i][j-1] = true;
        //             q.add(new Pair(new int[]{i,j-1},val+1));
        //         }
        //     }
        // }
        // return -1;
    }
}