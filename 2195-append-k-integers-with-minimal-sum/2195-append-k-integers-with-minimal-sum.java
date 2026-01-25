class Solution {
    public long minimalKSum(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;
        int used = 0;
        long ans = 0;
        int last = 0;

        

        for(int i=0;i<n;i++){

            int gap = nums[i]-last-1;
            if (gap>0) {
                if (used+gap>k)
                    gap=k-used;

                ans += add(last + 1, last + gap);
                used += gap;
            }
            last = nums[i];
        }
        if (used < k) {
            ans += add(last + 1, last + (k - used));
        }
        return ans;
    }

     private long add(long l, long r) {
        return (r * (r + 1)) / 2 - ((l - 1) * l) / 2;
    }
}