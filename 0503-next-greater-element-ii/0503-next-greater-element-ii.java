class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0;i<2*n;i++){
            int idx = i % n;
            while(!st.isEmpty() && nums[st.peek()]<nums[idx]){
                ans[st.pop()] = nums[idx];
            }
            if (i < n) st.push(idx);
        }
        return ans;
    }
}