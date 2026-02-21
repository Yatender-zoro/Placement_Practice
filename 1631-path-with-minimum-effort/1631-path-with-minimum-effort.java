class Solution {
    public int minimumEffortPath(int[][] h) {
        int m = h.length;
        int n = h[0].length;

        int[][] d = new int[m][n];

        for(int i=0;i<m;i++) Arrays.fill(d[i],Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // start from 0,0
        pq.add(new int[]{0,0,0}); // dist, i ,j

        d[0][0] = 0;


        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int dist = e[0];
            int i = e[1];
            int j = e[2];

            if(i==m-1 && j==n-1) return dist;

            for(int l=0;l<4;l++){
                int nr = i + dx[l];
                int nc = j + dy[l];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int diff = Math.abs(h[i][j] - h[nr][nc]);
                    int newEff = Math.max(dist, diff);
                    if(newEff < d[nr][nc]){
                        d[nr][nc] = newEff;
                        pq.add(new int[]{newEff,nr,nc});
                    }
                }
            }
        }

        return 0;
    }
}