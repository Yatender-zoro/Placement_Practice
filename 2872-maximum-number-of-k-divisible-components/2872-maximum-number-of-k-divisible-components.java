class Solution {
    int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            
            adj.add(new ArrayList<>());
        }
        //boolean vis[] = new boolean[n];

        for(int[] x:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        dfs(0,adj,values,k,-1);
        return ans;
    }

    long dfs(int node, List<List<Integer>> adj ,int[] values,int k,int parent){
        
        long s = values[node];
        for(int x:adj.get(node)){

            if(x == parent) continue;
            s += dfs(x,adj,values,k,node);            
            
        }
        if(s%k==0){
            ans++;
            return 0;
        }

        return s%k;
    }
}