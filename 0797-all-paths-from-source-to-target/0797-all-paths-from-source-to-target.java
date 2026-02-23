class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length;
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        DFS(0,n-1,adj,new ArrayList<>());
        return ans;
    }

    void DFS(int st,int en,List<List<Integer>> adj,List<Integer> t){
        
        t.add(st);
       
        if(st == en){
            ans.add(new ArrayList<>(t));
            t.remove(t.size()-1);
            return;
        }

        for(int x:adj.get(st)){
            DFS(x,en,adj,t);
        }


        t.remove(t.size()-1);
       
    }
}