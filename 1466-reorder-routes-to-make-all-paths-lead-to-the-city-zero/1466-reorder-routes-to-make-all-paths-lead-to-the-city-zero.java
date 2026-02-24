class Solution {
    int ans;
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] x:connections){
            adj.get(x[0]).add(new int[]{x[1],1});
            adj.get(x[1]).add(new int[]{x[0],0});
        }

        boolean[] vis = new boolean[n];

        ans = 0;
        DFS(0,adj,vis);
        return ans;
    }

    void DFS(int idx,List<List<int[]>> adj ,boolean[] vis){

        vis[idx] = true;

        for(int[] x:adj.get(idx)){
            int nxtnode = x[0];
            int real = x[1];

            if(!vis[nxtnode]){
                ans+=real;
                DFS(nxtnode,adj,vis);
            } 
        }
    }
}