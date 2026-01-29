class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n]; // store the max sum till ith index
        Deque<Integer> dq = new ArrayDeque<>(); // to store the max sum till kth window

        dp[0] = nums[0];
        dq.add(0);

        for(int i=1;i<n;i++){
            // if(i>k){           
            //     if(i-dq.peekFirst()>k) dq.pollFirst();
            // }

            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // if(dq.isEmpty()) dp[i] = nums[i];
             dp[i] =nums[i]+dp[dq.peekFirst()];
            while(!dq.isEmpty() && dp[i]>dp[dq.peekLast()]){
                dq.pollLast();
            }
            dq.add(i);
        }
        return dp[n-1];
    }
}