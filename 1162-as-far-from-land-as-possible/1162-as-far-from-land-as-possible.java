class Solution {
    public int maxDistance(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] d= new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        int w = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                  w++;
                  
                } 
                else{
                    q.add(new int[]{i,j});
                }
            }
        }

        if(w==0 || q.size() == 0) return -1;
        w = 0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            int[] data = q.poll();
            int r = data[0];
            int c = data[1];
           // int dist = data[2];

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    if(grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        d[nr][nc] = d[r][c] + 1;
                        w = Math.max(w,d[nr][nc]);
                        q.add(new int[]{nr,nc});
                        
                    }
                }
            }
        }
        return w;
    }
}