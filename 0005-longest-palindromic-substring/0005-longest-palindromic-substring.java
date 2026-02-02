class Solution {
    // Boolean dp[][];
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int maxl = 0;
        int idx = 0;
        for(int i=0;i<n;i++){
            dp[i][i] =true;
            maxl = 1;
        }

        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j = i+L-1;

                if(s.charAt(i)==s.charAt(j) && L==2){
                    maxl = 2;
                    dp[i][j] = true;
                    idx = i;
                }
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(j-i+1>maxl){
                        maxl = j-i+1;
                        idx = i;
                    }
                }
                else dp[i][j] = false;
            }
        }

        return s.substring(idx,idx+maxl);
        // int n = s.length();
        // int ans = 0;
        // int st = 0;

        // dp = new Boolean[n][n];

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         if(solve(i,j,s)){
        //             if(j-i+1>ans){
        //                 ans  = j-i+1;
        //                 st = i;
        //             }
        //         }
        //     }
        // }
        // return s.substring(st,st+ans);
    }

    // public boolean solve(int i,int j,String s){
    //     if(i>j) return true;

    //     if(dp[i][j]!=null) return dp[i][j];

    //     if(s.charAt(i)==s.charAt(j))
    //         return dp[i][j] = solve(i+1,j-1,s);
        
    //     return dp[i][j] = false;
    // }
}