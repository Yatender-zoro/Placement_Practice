class Solution {
    public int swimInWater(int[][] g) {
        int m = g.length,n = g[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        pq.add(new int[]{0,0,g[0][0]}); // i , j , dist
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int r = e[0];
            int c = e[1];
            int d = e[2];

            if(r==m-1 && c == n-1) return d;
            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(!vis[nr][nc]){
                        int len = Math.max(d,g[nr][nc]);
                        pq.add(new int[]{nr,nc,len});
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        return 0;
    }
}