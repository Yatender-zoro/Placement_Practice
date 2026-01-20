class Solution {
    public int sumSubarrayMins(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            left[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            right[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            int rmin = right[i]-i;
            int lmin = i-left[i];
            long p = (1L *rmin*lmin*nums[i])%mod;
            ans = (ans + p) % mod;
        }
        return (int)ans%mod;
    }
}