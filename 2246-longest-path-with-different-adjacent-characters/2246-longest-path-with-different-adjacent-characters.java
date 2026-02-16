class Solution {
    int max = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=1;i<n;i++){
            adj.get(parent[i]).add(i);
        }

        dfs(0, adj, s);
        return max;
    }
    
    int dfs(int node, List<List<Integer>> adj, String s){
        int longest = 0;
        int second = 0;

        for(int child : adj.get(node)){
            int len = dfs(child, adj, s);

            if(s.charAt(child) == s.charAt(node)) continue;

            if(len > longest){
                second = longest;
                longest = len;
            } else if(len > second){
                second = len;
            }
        }

        max = Math.max(max, longest + second + 1);
        return longest + 1;
    }
}