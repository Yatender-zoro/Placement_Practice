class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] x:flights){
            adj.get(x[0]).add(new int[]{x[1],x[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);

        q.add(new int[]{src,0,0});
        dist[src] = 0;

        while(!q.isEmpty()){
            int node = q.peek()[0];
            int wt = q.peek()[1];
            int lvl = q.peek()[2];
            q.poll();

            if(lvl>k) break;
            //if(dist[node]!=wt) continue;
            for(int[] x:adj.get(node)){
                int nn = x[0];
                int nwt = x[1];
                int nlvl = lvl+1;
                if(dist[nn]>wt+nwt){
                    dist[nn] = wt+nwt;
                    q.add(new int[]{nn,dist[nn],nlvl});
                }
            }
        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}