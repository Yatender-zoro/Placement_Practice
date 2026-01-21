class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] leftmin = new int[n];
        int[] rightmin = new int[n];

        int[] leftmax = new int[n];
        int[] rightmax = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            leftmin[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            rightmin[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            leftmax[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                st.pop();
            }
            rightmax[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }


        long minc = 0;
        for(int i=0;i<n;i++){
            int rmin = rightmin[i]-i;
            int lmin = i-leftmin[i];
            long p = (1L *rmin*lmin*nums[i]);
            minc = (minc+ p) ;
        }
        long maxc = 0;
        for(int i=0;i<n;i++){
            int rmax = rightmax[i]-i;
            int lmax = i-leftmax[i];
            long p = (1L *rmax*lmax*nums[i]);
            maxc = (maxc + p) ;
        }

        return maxc-minc;
    }
}