class Solution {
    public int lengthOfLIS(int[] nums) {
        // patience sorting do this task in nlogn by binary search we use it when we need lis lenght not its actual array and print 

        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(li.size()==0) li.add(nums[i]);
            else{
                int result = lowerBound(nums[i],li);
                if(result==li.size()){
                    li.add(nums[i]);
                }
                else li.set(result, nums[i]);
            }
        }
        return li.size();
    }

    public int lowerBound(int e,List<Integer>li){
        int st = 0,en = li.size()-1;
        int ans = en+1;
        while(st<=en){
            int mid = en - (en-st)/2;
            if(li.get(mid)>=e){
                ans = mid;
                en = mid-1;
            }
            else{
                st = mid+1;
            }
            
        }
        return ans;
    }
}