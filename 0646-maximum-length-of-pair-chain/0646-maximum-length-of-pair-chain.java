class Solution {
    // int n;
    // int[][] dp;
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n+1];
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0])); 
        Arrays.fill(dp,1);

        int maxi = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxi = Math.max(dp[i],maxi);
                }
            }
        }

        return maxi;
        // dp = new int[n][n+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return maxLen(pairs,0,-1);
    }

    // public int maxLen(int[][] pairs, int idx, int p){
    //     if(idx==n) return 0;

    //     // take
    //     int take=0;
    //     if(dp[idx][p+1]!=-1) return dp[idx][p+1];

    //     if(p==-1 || pairs[idx][0]>pairs[p][1])
    //         take = 1+maxLen(pairs,idx+1,idx);

    //     // skip
    //     int skip = maxLen(pairs,idx+1,p);

    //     return dp[idx][p+1] = Math.max(take,skip);
        
    // }
}