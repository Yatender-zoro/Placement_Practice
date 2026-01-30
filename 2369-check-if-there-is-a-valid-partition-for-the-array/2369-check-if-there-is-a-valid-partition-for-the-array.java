class Solution {

    Boolean[][] dp;
    public boolean validPartition(int[] nums) {
         dp = new Boolean[nums.length+1][3];
        // return solve(0,nums);
        return solve(0, 1, nums) || solve(0, 2, nums);
    }

    public boolean solve(int i,int j,int[] nums){
        int n = nums.length;
        if (i == n) return true;
        if (j >= n) return false;

        int len = j - i;
        if (dp[i][len] != null) return dp[i][len];
        return dp[i][len] = check(i, j, nums);
    //     int n = nums.length;
    //     if(i==n) return true;
       
    //     if (i + 1 < n && nums[i] == nums[i + 1]) {
    //         if (solve(i + 2, nums)) return true;
    //     }

    //      if (i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
    //         if (solve(i + 3, nums)) return true;
    //     }
    //     if (i + 2 < n && nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
    //         if (solve(i + 3, nums)) return true;
    //     }
    //     return false;
     }

     public boolean check(int i, int j, int[] nums) {

        // length 2 block
        if (j - i == 1) {
            if (nums[i] == nums[j]) {
                return solve(j + 1, j + 2, nums) || solve(j + 1, j + 3, nums);
            }
            return false;
        }

        // length 3 block
        else {
            boolean allEqual = (nums[i] == nums[i + 1] && nums[i + 1] == nums[j]);
            boolean consecutive = (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[j]);

            if (allEqual || consecutive) {
                return solve(j + 1, j + 2, nums) || solve(j + 1, j + 3, nums);
            }
            return false;
        }
    }

}