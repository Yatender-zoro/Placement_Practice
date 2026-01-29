class Solution {
    public int maxFrequency(int[] nums, int k) {

        int dp[] = new int[51];
        int countK = 0;
        int max = 0;

        for (int x: nums) {
            if (x == k) {
                countK++;
                dp[x] = max + 1;
            } else {
                dp[x] = Math.max(dp[x] + 1, countK + 1);
            }

            max = Math.max(max, dp[x]);
        }
        
        return max;
    //    int n = nums.length;
    //     int base = 0;
    //     for (int x : nums) {
    //         if (x == k) base++;
    //     }
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int x : nums) {
    //         if (x != k) set.add(x);
    //     }

    //     int bestGain = 0;

    //     for (int val : set) {
    //         int curr = 0;
    //         int maxHere = 0;

    //         for (int x : nums) {
    //             int score = 0;
    //             if (x == val) score = 1;
    //             else if (x == k) score = -1;

    //             curr = Math.max(score, curr + score);
    //             maxHere = Math.max(maxHere, curr);
    //         }

    //         bestGain = Math.max(bestGain, maxHere);
    //     }

    //     return base + bestGain;
    }

}