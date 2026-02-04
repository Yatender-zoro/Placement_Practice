class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], len = e[2];
            adj.get(u).add(new int[]{v, len});
            adj.get(v).add(new int[]{u, len}); // undirected
        }

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // {time, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];

            if (time > minTime[node]) continue; // already better
            if (time >= disappear[node]) continue; // node disappeared

            for (int[] next : adj.get(node)) {
                int nei = next[0], len = next[1];
                int arrival = time + len;
                if (arrival < minTime[nei] && arrival < disappear[nei]) {
                    minTime[nei] = arrival;
                    pq.offer(new int[]{arrival, nei});
                }
            }
        }

        for (int i = 0; i < n; i++) if (minTime[i] == Integer.MAX_VALUE) minTime[i] = -1;

        return minTime;
    }
}
