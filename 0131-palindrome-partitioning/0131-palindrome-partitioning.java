class Solution {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] =true;
        }

        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j = i+L-1;
                if(s.charAt(i)==s.charAt(j) && L==2){                   
                    dp[i][j] = true;
                }
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
                else dp[i][j] = false;
            }
        }
        List<List<String>> li = new ArrayList<>();
        partition(0,s,new ArrayList<String>(),li);
        return li;
    }

    public void partition(int index,String s,List<String> e, List<List<String>> li){

        if (index == s.length()) {
            li.add(new ArrayList<>(e));
            return;
        }
        for(int i=index;i<s.length();i++){
            String sub = s.substring(index, i + 1);
            if(dp[index][i]){
                e.add(sub);
                partition(i+1,s,e,li);
                e.remove(e.size() - 1);
            }
        }
    }


    // public List<List<String>> partition(String s) {
    //     List<List<String>> li = new ArrayList<>();
    //     partition(0,s,new ArrayList<String>(),li);
    //     return li;
    // }

    // public void partition(int index,String s,List<String> e, List<List<String>> li){

    //     if (index == s.length()) {
    //         li.add(new ArrayList<>(e));
    //         return;
    //     }
    //     for(int i=index;i<s.length();i++){
    //         String sub = s.substring(index, i + 1);
    //         if(isp(sub)){
    //             e.add(sub);
    //             partition(i+1,s,e,li);
    //             e.remove(e.size() - 1);
    //         }
    //     }
    // }

    // public boolean isp(String x){
    //     int m = x.length();
    //     if(m==1){
    //         return true;
    //     }
    //     if(m==0){
    //         return false;
    //     }
    //     int a=0,b=m-1;
    //     while(a<=b){
    //         if(x.charAt(a)!=x.charAt(b)) return false;
    //         a++;
    //         b--;
    //     }
    // return true;
    // }
}