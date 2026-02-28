class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] x:times){
            adj.get(x[0]).add(new int[]{x[1],x[2]});
        }

        int ttime = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)1e9);

        pq.add(new int[]{k,0});
        dist[k] = 0;

        while(!pq.isEmpty()){
            
            int size = pq.size();
            for(int i =0 ;i<size;i++){
                int[] curr = pq.poll();
                int node = curr[0];
                int time = curr[1];

                for(int[] nei:adj.get(node)){
                    int neinode = nei[0];
                    int neitime = nei[1];

                    if(dist[neinode]>time + neitime){
                        dist[neinode] = time + neitime;
                        pq.add(new int[]{neinode,dist[neinode]});
                    }
                }
            }

        }

        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9) return -1;
            ttime = Math.max(ttime,dist[i]);
        }
        return ttime;
    }
}