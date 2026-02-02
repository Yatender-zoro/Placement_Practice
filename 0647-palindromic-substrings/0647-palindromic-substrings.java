class Solution {
    Boolean[][] dp;
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        dp = new Boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isP(s,i,j)) count++;
            }
        }
        return count;
    }

    public boolean isP(String s,int i, int j){
        if(i>j) return true;

        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = isP(s,i+1,j-1);
        }
        return false;
    }
}