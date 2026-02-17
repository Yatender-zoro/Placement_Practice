class Solution {
    HashSet<String> set ;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        dp = new Boolean[s.length()+1];
        for(String x:wordDict) set.add(x);

        return solve(0,s);
    }
    
    boolean solve(int i,String s){
        
        if(i >= s.length()) return true;

        if(dp[i]!=null) return dp[i];
        for(int l=1;i+l<=s.length();l++){
            String s1 = s.substring(i,i+l);
            if(set.contains(s1) && solve(i+l,s)) return dp[i] = true;
        }
        return dp[i] = false;
    }


    // HashSet<String> set ;
    // Boolean[][] dp;
    // public boolean wordBreak(String s, List<String> wordDict) {
    //    set = new HashSet<>();
    //     dp = new Boolean[s.length()+1][s.length()+1];
    //     for(String x:wordDict) set.add(x);

    //     return solve(0,1,s);
    // }

    // boolean solve(int i,int j,String s){
        
    //     String s1 = s.substring(i,j);
    //     if(j == s.length()){
    //         return set.contains(s1);
    //     }

    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(set.contains(s1)){
    //         return  dp[i][j] = solve(j,j+1,s) || solve(i,j+1,s);
    //     }

    //     return dp[i][j] = solve(i,j+1,s);
    // }
}