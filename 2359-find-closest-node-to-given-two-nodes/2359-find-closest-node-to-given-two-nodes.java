class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] n1dist = new int[n];
        int[] n2dist = new int[n];

        Arrays.fill(n1dist, -1);
        Arrays.fill(n2dist, -1);

        int c = 0;
        int cur = node1;
        while (cur != -1 && n1dist[cur] == -1) {
            n1dist[cur] = c++;
            cur = edges[cur];
        }
        c = 0;
        cur = node2;
        while (cur != -1 && n2dist[cur] == -1) {
            n2dist[cur] = c++;
            cur = edges[cur];
        }


        int mini = Integer.MAX_VALUE;
        int ans = -1;

        for(int j=0;j<n;j++){
            if (n1dist[j] == -1 || n2dist[j] == -1) continue;
            int maxi = Math.max(n1dist[j],n2dist[j]);
            if(maxi<mini){
                mini = maxi;
                ans = j; 
            }
        }
        return ans;
    }
}