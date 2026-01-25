class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int p = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.addLast(i);
             if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            if(i>=k-1){
                ans[p++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}