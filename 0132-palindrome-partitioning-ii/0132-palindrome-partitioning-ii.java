class Solution {
    public int minCut(String s) {
        int n = s.length();

        boolean[][] tab = new boolean[n][n];

        for(int i=0;i<n;i++) tab[i][i] = true;

        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j = i+l-1;

                if(s.charAt(i)==s.charAt(j) && l==2) tab[i][j] = true;
                else  tab[i][j] = (s.charAt(i)==s.charAt(j)) && tab[i+1][j-1];
            }
        }

        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            if(tab[0][i]){
                dp[i] = 0;
            }
            else{
                dp[i] = Integer.MAX_VALUE;

                for(int k=0;k<i;k++){
                    if(tab[k+1][i] && 1+dp[k]<dp[i]) dp[i] = 1+dp[k];
                }
            }
        }
        return dp[n-1];
    }
}