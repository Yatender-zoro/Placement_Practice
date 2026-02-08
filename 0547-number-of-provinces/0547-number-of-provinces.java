
class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer>  size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        
        int pn = findUPar(parent.get(node));
        parent.set(node,pn);
        return pn;
    }
    
    public void unionBySize(int u,int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu==pv) return;
        
        if(size.get(pu)>size.get(pv)){
            parent.set(pv,pu);
            size.set(pv,size.get(pv)+size.get(pu));
        }
        
        else{
            parent.set(pu,pv);
            size.set(pu,size.get(pv)+size.get(pu));
        }
    }
}

class Solution {
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        DisjointSet ds = new DisjointSet(V); 
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j]==1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<V;i++){
            if(ds.findUPar(i)==i) cnt++;
        }
        return cnt;
    //    int V = isConnected.length;
    //     boolean[] vis = new boolean[V];
    //     int c = 0;

    //     for(int i = 0; i < V; i++){
    //         if(!vis[i]){
    //             c++;
    //             bfs(i, isConnected, vis);
    //         }
    //     }
    //     return c;
    }

    // public void bfs(int i, int[][] isConnected, boolean[] vis){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(i);
    //     vis[i] = true;

    //     while(!q.isEmpty()){
    //         int u = q.poll();
    //         for(int v = 0; v < isConnected.length; v++){
    //             if(isConnected[u][v] == 1 && !vis[v]){
    //                 vis[v] = true;
    //                 q.add(v);
    //             }
    //         }
    //     }
    // }
}