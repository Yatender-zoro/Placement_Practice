class Solution {
    class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int u,int v){
            int u_par = find(u);
            int v_par = find(v);

            if(u_par == v_par) return;

            if(size[u_par]>=size[v_par]){
                parent[v_par] = u_par;
                size[u_par] += size[v_par];
            }
            else{
                parent[u_par] = v_par;
                size[v_par] += size[u_par];
            }
        }
    }
    public int countServers(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        DSU ds = new DSU(n+m);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ds.union(i,j+n);
                }
            }
        }

        int[] count = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int parent = ds.find(i);
                    count[parent]++;
                }
            }
        }

        int ans = 0;

        for (int c : count) {
            if (c > 1) ans += c;
        }

        return ans;
    }
}