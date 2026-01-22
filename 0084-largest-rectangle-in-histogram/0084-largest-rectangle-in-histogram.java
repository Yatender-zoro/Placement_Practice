class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        
        // int ls[] = new int[n];
        // int rs[] = new int[n];
        // Stack<Integer> st = new Stack<>();
        // for(int i=0;i<n;i++){
        //     while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
        //         st.pop();
        //     }
        //     ls[i] = st.isEmpty()?-1:st.peek();
        //     st.push(i);
        // }
        // st.clear();

        // for(int i=n-1;i>=0;i--){
        //     while(!st.isEmpty() && nums[st.peek()]>nums[i]){
        //         st.pop();
        //     }
        //     rs[i] = st.isEmpty()?n:st.peek();
        //     st.push(i);
        // }
        // int ans = 0;
        // for(int i=0;i<n;i++){
        //     int width = rs[i] - ls[i] - 1;
        //     int area  = width * nums[i];
        //     ans = Math.max(ans,area);
        // }
        // return ans;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                int e = st.pop();
                int ls = st.isEmpty()?-1:st.peek();
                ans = Math.max(ans,(i-ls-1)*nums[e]);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int e = st.pop();
            int rs = n;
            int ls = st.isEmpty()?-1:st.peek();
            ans = Math.max(ans,(rs-ls-1)*nums[e]);
        }
        return ans;
    }
}