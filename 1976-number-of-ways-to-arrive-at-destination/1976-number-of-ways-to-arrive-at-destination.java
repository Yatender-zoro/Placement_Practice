class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]x:roads){
            adj.get(x[0]).add(new int[]{x[1],x[2]});
            adj.get(x[1]).add(new int[]{x[0],x[2]});
        }

        q.add(new long[]{0,0});
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        while(!q.isEmpty()){
            long[] cur = q.poll();
            int node = (int) cur[0];
            long wt = cur[1];
            if (wt > dist[node]) continue;

            for(int[] x:adj.get(node)){
                int nn = x[0];
                long nwt = x[1];

                if(wt+nwt<dist[nn]){
                    dist[nn] = wt+nwt;
                    ways[nn] = ways[node];
                    q.add(new long[]{nn, dist[nn]});
                }
                else if(wt+nwt==dist[nn]){
                    ways[nn]=(ways[node]+ways[nn])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}