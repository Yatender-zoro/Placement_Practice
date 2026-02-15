class Solution {
    long fuel = 0;
    int seats;
    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;

         int n = roads.length + 1;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] x: roads){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        dfs(0, -1, adj);
        return fuel;
    }

    long dfs(int node, int parent, List<List<Integer>> adj){
        long people = 1;

        for(int nei : adj.get(node)){
            if(nei == parent) continue;
            people += dfs(nei, node, adj);
        }

        if(node != 0){
            fuel += (people + seats - 1) / seats; 
        }

        return people;
    }
}