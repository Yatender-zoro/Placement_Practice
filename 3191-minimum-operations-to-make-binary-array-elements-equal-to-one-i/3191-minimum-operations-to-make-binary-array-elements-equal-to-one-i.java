class Solution {
    public int minOperations(int[] nums) {
        int i=0;
        int count=0;
        int n = nums.length;
        while(i<n-2){
            if(nums[i]!=1){
               nums[i] = (nums[i] == 0) ? 1 : 0;
                nums[i+1] = (nums[i+1] == 0) ? 1 : 0;
                nums[i+2] = (nums[i+2] == 0) ? 1 : 0;
                count++;
            }
            i++;
        }
        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            return -1;
        }
        return count;
    }
}