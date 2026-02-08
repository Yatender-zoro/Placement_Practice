class Solution {
    // int[][] dp;
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            int sq = i * i;
            for (int sum = sq; sum <= n; sum++) {
                dp[sum] = Math.min(dp[sum], dp[sum - sq] + 1);
            }
        }
        return dp[n];
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i=1;i*i<=n;i++){
        //     list.add(i*i);
        // }
        // int l = list.size();
        // dp = new int[n+1][l];
        // for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

        // return solve(list,n,l-1);
    }

    // public int solve(ArrayList<Integer> list, int sum , int idx){
    //     if(sum==0) return 0;
    //     else if(sum<0 || idx<0) return Integer.MAX_VALUE;

    //     if(dp[sum][idx]!=-1) return dp[sum][idx];
    //     int take = Integer.MAX_VALUE;
    //     take = solve(list,sum-list.get(idx),idx);
    //     if(take!=Integer.MAX_VALUE) take++;
    //     int skip = solve(list,sum,idx-1);

    //     return dp[sum][idx] = Math.min(take,skip);
    // }
}

