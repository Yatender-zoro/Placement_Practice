class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];

        for(int[] x:p){
            adj.get(x[0]).add(x[1]);
        }

        for(int i=0;i<n;i++){
            if(!vis[i])
                if(dfs(i,adj,vis,pathvis)) return false;
        }
        return true;

    }
    boolean dfs(int node,List<List<Integer>> adj ,boolean[] vis ,boolean[] pathvis){
        

        if(pathvis[node] == true) return true;
        if(vis[node]) return false;

        vis[node] = true;
        pathvis[node] = true;

        for(int x:adj.get(node)){
            if(dfs(x,adj,vis,pathvis)){
                return true;
            }
        }
        
        pathvis[node] = false;
        return false;
        
    }
}