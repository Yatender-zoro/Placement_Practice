class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target)
            return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int x : routes[i]) {
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(i);
            }
        }
        boolean[] vis = new boolean[501];
        Queue<Integer> q = new LinkedList<>();
        
        if (!map.containsKey(source)) return -1;

        for(int x:map.get(source)){
            q.add(x);
            vis[x] = true;
        }

        int busCount = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                int e = q.poll();

                for(int x:routes[e]){
                    if(x == target){
                        return busCount+1;
                    }

                    for(int rs:map.get(x)){
                        if(!vis[rs]){
                            vis[rs] = true;
                            q.add(rs);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}