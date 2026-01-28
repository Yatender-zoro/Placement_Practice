class Solution {
    //int[][] dp;

    // public int maxLen(int[] nums,int idx,int prev){
    //     if(idx==nums.length) return 0;

    //     //take
    //     if(prev!=-1 && dp[idx][prev]!=-1) return dp[idx][prev];
    //     int take = 0;
    //     if(prev==-1 || nums[idx]>nums[prev])
    //         take = 1+maxLen(nums,idx+1,idx);
        
    //     //skip

    //     int skip = maxLen(nums,idx+1,prev);

    //     if(prev!=-1) dp[idx][prev] = Math.max(take,skip);
    //     return  Math.max(take,skip);
    // }
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        // dp = new int[n+1][n+1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return maxLen(nums,0,-1); 


        int[] dp = new int[n]; // here dp[i] tells us maxlen of subarray ending at index i;

        Arrays.fill(dp,1); // as all elements are increasing  

        int maxi = dp[0];
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxi = Math.max(maxi,dp[i]);
                }
            }
        }     

        return maxi;
        // List<Integer> list = new ArrayList<>();
        // int len = 0;
        // list.add(nums[0]);
        // len++;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]>list.get(list.size() - 1)){
        //         list.add(nums[i]);
        //         len++;
        //     }
        //     else{
        //         int st = 0,en = list.size()-1;
                
        //         while(st<=en){
        //             int mid = (st+en)/2;
        //             if(list.get(mid)>=nums[i]){
        //                 en = mid-1;
        //             }
        //             else if(list.get(mid)<=nums[i]){
        //                 st = mid+1;
        //             }
        //         }
        //         list.set(st,nums[i]);
        //     }
        // }
        // return len;
    }
}