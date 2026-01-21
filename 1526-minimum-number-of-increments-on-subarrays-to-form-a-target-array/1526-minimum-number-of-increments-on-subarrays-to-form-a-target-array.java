class Solution {
    public int minNumberOperations(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                ans+=(nums[i+1]-nums[i]);
            }
        }
        return ans;
    }
}