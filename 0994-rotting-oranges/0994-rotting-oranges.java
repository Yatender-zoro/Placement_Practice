class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();


        int fc = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1) fc++;
            }
        }

        if(fc==0) return 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int ans = -1;
        while(!q.isEmpty()){

            int size = q.size();

            for(int j=0;j<size;j++){

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                
                for(int i=0;i<4;i++){
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if(nr>=0 && nr<m && nc>=0 && nc<n){
                        if(grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            q.add(new int[]{nr,nc});
                        }
                    }
                }
            } 
            ans++;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return ans;
    }
}