class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length,c=matrix[0].length;
        int[][] dp = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0) ? 1 : dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                while(!st.isEmpty() && dp[i][st.peek()]>=dp[i][j]){
                    int ei = st.pop();
                    int lm = st.isEmpty()?-1:st.peek();
                    ans = Math.max(ans,(j-lm-1)*dp[i][ei]);
                }
                st.push(j);
            }
            while(!st.isEmpty()){
                int ei = st.pop();
                int rm = c;
                int lm = st.isEmpty()?-1:st.peek();
                ans = Math.max(ans,(rm-lm-1)*dp[i][ei]);
            }
            st.clear();
        }
        return ans;
    }
}