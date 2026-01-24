class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++){
            dp[i][0] = limit[i];
            dp[i][1] = value[i];
        }

        Arrays.sort(dp,(a,b)->a[0]==b[0]?Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]));

        int currA = 0;
        long val = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ac = new LinkedList<>();

        for(int i=0;i<n;i++) q.add(i);

        while(!q.isEmpty()){
            while(!q.isEmpty() && currA>=dp[q.peek()][0]){
                q.poll();
            }
            if(q.isEmpty()) break;
            int idx = q.poll();
            int l = dp[idx][0];

            while(!ac.isEmpty() && ac.peek()<=currA){
                ac.poll();
                currA--;
            }
            
            if(currA<l){
                ac.add(l);
                val+=dp[idx][1];
                currA++;
            }
            
        }
        return val;
    }
}