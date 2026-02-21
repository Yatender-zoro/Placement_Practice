class Solution {
    public int[] findOrder(int n, int[][] p) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] x:p){
            adj.get(x[1]).add(x[0]);
        }

        int[] ind = new int[n];

        for(int i=0;i<p.length;i++){
            ind[p[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(ind[i]==0) q.add(i);
        }

        int k = 0;
        int[] ans = new int[n];

        while(!q.isEmpty()){
            int node = q.poll();
            ans[k++] = node;

            for(int x:adj.get(node)){
                ind[x]--;
                if(ind[x]==0){
                    q.add(x);
                }
            }
        }

        if(k!=n) return new int[]{};
        return ans;
    }
}