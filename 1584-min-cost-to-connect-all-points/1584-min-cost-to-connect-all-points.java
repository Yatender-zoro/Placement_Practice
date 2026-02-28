import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
       
        minDist[0] = 0;
        pq.offer(new int[]{0, 0});

        int cost = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            if (visited[u]) continue;
            visited[u] = true;
            cost += curr[1];

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);

                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                        pq.offer(new int[]{v, dist});
                    }
                }
            }
        }

        return cost;
    }
}