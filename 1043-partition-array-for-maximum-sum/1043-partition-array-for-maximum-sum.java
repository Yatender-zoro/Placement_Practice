class Solution {
    int n;
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
    
        this.n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
       return solve(0,arr,k);
    }

    public int solve(int i,int[] arr, int k){
        
        if(i>=n) return 0;
        int result = 0;
        int max = -1;

        if(dp[i]!=-1) return dp[i];

        for(int j=i;j<n && j-i+1<=k ; j++){
            max = Math.max(max,arr[j]);
            result = Math.max(result,(j-i+1)*max + solve(j+1,arr,k));
        }
        return dp[i] = result;
    }
}