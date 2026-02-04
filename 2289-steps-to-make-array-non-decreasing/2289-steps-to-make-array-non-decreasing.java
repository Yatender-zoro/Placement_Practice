class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                int e = st.pop();
                dp[i] = Math.max(dp[i]+1,dp[e]);
                
            }
            st.push(i);
        }
        int maxi = 0;
        for(int x:dp){
            maxi = Math.max(x,maxi);
        }

        return maxi;
    }
}