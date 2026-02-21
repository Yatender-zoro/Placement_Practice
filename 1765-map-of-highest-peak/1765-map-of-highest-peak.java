class Solution {
    public int[][] highestPeak(int[][] mat) {
         int m = mat.length;
        int n = mat[0].length;
        int[][] d = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    d[i][j] = 0;
                    q.add(new int[]{i,j});
                }
                else d[i][j] = -1;
            }
        }

        
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for(int k=0;k<4;k++){
                int nr = cr+dx[k];
                int nc = cc+dy[k];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(d[nr][nc] == -1){
                        d[nr][nc] = d[cr][cc] + 1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }     

        return d;
    }
}