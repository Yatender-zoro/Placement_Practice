class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] x:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int x:restricted) set.add(x);
        boolean[] vis = new boolean[n];
        return  solve(set,0,adj,vis);
    }

    public int solve(HashSet<Integer> set, int i, List<List<Integer>> adj ,boolean[] vis){

        if(vis[i] || set.contains(i)) return 0;

        vis[i] = true;

        int result = 1;
        for(int x:adj.get(i)){
            
            result =(result + solve(set,x,adj,vis));
        }
        return result;
    }
}