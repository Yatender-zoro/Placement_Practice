class Solution {
        // bottom up
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        int[] pi = new int[n];
        Arrays.fill(pi,-1);

        int[] dp = new int[n];

        Arrays.fill(dp,1);

        for(int i =0;i<n;i++){
            for(int j=0;j<i;j++){
                if(i==j) continue;
                if(nums[i]%nums[j]==0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    pi[i] = j;
                }
            }
        }

        int max=0;
        int idx = 0;

        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max = dp[i];
                idx = i;
            }
        }

        while(idx!=-1){
            li.add(nums[idx]);
            idx = pi[idx];
        }
        Collections.reverse(li);
        return li;
    }


    // recursion 


    // public List<Integer> largestDivisibleSubset(int[] nums) {
    //     Arrays.sort(nums);
    //     List<Integer> ans = new ArrayList<>();
    //     List<Integer> currArr = new ArrayList<>();
    //     solve(0,-1,ans,currArr,nums);
    //     return ans;
    // }
    // public void solve(int i,int p,List<Integer> ans,List<Integer> currArr,int[] nums){
        
    //     if(i==nums.length){
    //         if(ans.size() < currArr.size()) {
    //             ans.clear();
    //             ans.addAll(currArr);
    //         }
    //         return;
    //     }
    //     // take
    //     if(p==-1 || nums[i]%p==0){
    //         currArr.add(nums[i]);
    //         solve(i+1,nums[i],ans,currArr,nums);
    //         currArr.remove(currArr.size()-1);
    //     }

    //     solve(i+1,p,ans,currArr,nums);
    // }
}