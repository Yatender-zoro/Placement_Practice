class Solution {
    //int[][] dp;
    public int longestStrChain(String[] words) {
        //sort by length
        int n = words.length;
        Arrays.sort(words,(a,b)->a.length() - b.length());
        // dp = new int[n][n+1];
        
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
         //2d state as 2 states are changing curr and prev
        // return solve(0,words,-1);

        int[] dp = new int[n];
        int maxl = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(isP(j,i,words)){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            maxl = Math.max(maxl,dp[i]);
        }
        return maxl;
    }

    // public int solve(int idx,String[] words,int p){
    //     if(idx==words.length) return 0;

    //     //take

    //     if(dp[idx][p+1]!=-1) return dp[idx][p+1];
    //     int take = 0;
    //     if(isP(idx,words,p)){
    //         take = 1+solve(idx+1,words,idx);
    //     }
    //     int skip = solve(idx+1,words,p);
        
    //     return dp[idx][p+1] = Math.max(take,skip);
    // }

    public boolean isP(int p,int idx,String[] words){
        if(p==-1) return true;
        String curr = words[idx];
        String prev = words[p];

        if(curr.length()!= prev.length()+1) return false;

        int i=0,j=0;
        int d = 1;
        while(i<curr.length() && j<prev.length()){
            if(curr.charAt(i)==prev.charAt(j)){
                i++;
                j++;
            }
            else{
                if(d!=1) return false;
                d--;
                i++;
            }
        }
        return true;
    }
}