class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxi = 0;
        int c = 0;
        int[] dp  = new int[n];
        for(int i=n-1;i>=0;i--){
            c=0;
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                c = Math.max(c + 1, dp[st.pop()]);
            }
            dp[i] = c;
            maxi = Math.max(maxi,c);
            st.push(i);
        }
        return maxi;
    }
}