class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        int c = 1;
        q.add(0);

        while(!q.isEmpty()){
            int node = q.poll();
            vis[node] = true;

            for(int x:rooms.get(node)){
                if(!vis[x]){
                    c++;
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return c == n;
    }
}