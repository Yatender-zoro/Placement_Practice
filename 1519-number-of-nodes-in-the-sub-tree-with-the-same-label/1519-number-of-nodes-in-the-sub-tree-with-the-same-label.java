class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] ans = new int[n];

        solve(0,-1,adj,labels,ans);
        return ans;
    }
    int[] solve(int node, int parent, List<List<Integer>> adj ,String labels,int[] ans){

        int[] f = new int[26];

        for(int v:adj.get(node)){
            if(v == parent) continue;

            int[] child = solve(v,node,adj,labels,ans);

            for(int i=0;i<26;i++){
                f[i]+=child[i];
            }

        }
        int idx = labels.charAt(node) - 'a';
        f[idx]++;

        ans[node] = f[idx];
        return f;
    }
}