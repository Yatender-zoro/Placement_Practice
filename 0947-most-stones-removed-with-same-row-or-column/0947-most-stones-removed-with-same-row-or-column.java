// class Solution {
//     public int removeStones(int[][] stones) {
//         int n = stones.length;
//         boolean[] vis = new boolean[n];

//         int grp = 0;
//         for(int i=0;i<n;i++){
//             if(vis[i]!=true){
//                 grp++;
//                 DFS(vis,stones,i);
//             }
//         }
//         return n - grp;
        
//     }
//     void DFS(boolean[] vis,int[][] stones,int i){
//         vis[i] = true;

//         int r = stones[i][0];
//         int c = stones[i][1];
//         for(int j=0;j<stones.length;j++){
//             if((r == stones[j][0] || c == stones[j][1]) && vis[j]==false){
//                 DFS(vis,stones,j);
//             }
//         }
//     }
// }

class Solution {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (size[pu] >= size[pv]) {
                parent[pv] = pu;
                size[pu] += size[pv];
            } else {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }

    public int removeStones(int[][] stones) {

        int OFFSET = 10001;
        DSU ds = new DSU(20002);

        boolean[] used = new boolean[20002];

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + OFFSET;

            ds.union(row, col);

            used[row] = true;
            used[col] = true;
        }

        int components = 0;

        for (int i = 0; i < 20002; i++) {
            if (used[i] && ds.find(i) == i) {
                components++;
            }
        }

        return stones.length - components;
    }
}