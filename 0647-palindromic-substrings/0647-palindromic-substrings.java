class Solution {
    public int countSubstrings(String s) {

        // bottom up
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        int cnt = 0;

        for(int l =1;l<=n;l++){
            for(int i=0;l+i-1<n;i++){
                int j = l+i-1;

                if(i==j) dp[i][j] = true;
                else if(i+1==j) dp[i][j] = s.charAt(i)==s.charAt(j);

                else {
                    dp[i][j] = (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
                }

                if(dp[i][j]) cnt++;
            }
        }
        return cnt;
    }
    // Boolean[][] dp;
    // public int countSubstrings(String s) {
    //     int n = s.length();
    //     int count = 0;
    //     dp = new Boolean[n][n];
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(isP(s,i,j)) count++;
    //         }
    //     }
    //     return count;
    // }

    // public boolean isP(String s,int i, int j){
    //     if(i>j) return true;

    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(s.charAt(i)==s.charAt(j)){
    //         return dp[i][j] = isP(s,i+1,j-1);
    //     }
    //     return false;
    // }
}