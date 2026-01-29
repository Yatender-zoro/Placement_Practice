class Solution {
    int n,k,m;
    int mod = 1000000007;
    int[][][] dp; // 3 state dp for idx,sc,maxi as all are changing
    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.k = k;
        this.m = m;
        dp = new int[n][k+1][m+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++) Arrays.fill(dp[i][j],-1);
        }
        return solve(0,0,0);
    }

    public int solve(int idx,int sc,int maxi){
        if(sc > k) return 0;
        if(idx==n){
            if(sc==k) return 1;
            return 0;
        }
        if(dp[idx][sc][maxi]!=-1) return dp[idx][sc][maxi];
        int result = 0;
        for(int i=1;i<=m;i++){
            
            if(i>maxi){
                result = (result + solve(idx+1,sc+1,i))%mod;
            }
            else result = (result + solve(idx+1,sc,maxi))%mod;
        }
        return dp[idx][sc][maxi] = result%mod;
    }
}