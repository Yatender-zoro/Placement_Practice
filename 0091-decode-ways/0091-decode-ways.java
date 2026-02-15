class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        dp = new Integer[s.length()+1];
       return part(0,s);
    }

    public int part(int i,String s){

        if (i == s.length()) return 1;

        if(s.charAt(i)=='0') return 0;

        if(dp[i]!=null) return dp[i];
        int ans = part(i+1,s);

        if(i+1<s.length()){
            int val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if(val<=26)
            ans+=part(i+2,s);
        }
        return dp[i] = ans;
    }
}