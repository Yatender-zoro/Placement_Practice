class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1_000_000_007;
        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long sum = 0;
        int bestGain = 0;

        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];

            int curDiff = Math.abs(a - b);
            sum = (sum + curDiff) % mod;

            int idx = Arrays.binarySearch(sorted, b);
            if (idx < 0) idx = -idx - 1;

            if (idx < n) bestGain = Math.max(bestGain, curDiff - Math.abs(sorted[idx] - b));
            if (idx > 0) bestGain = Math.max(bestGain, curDiff - Math.abs(sorted[idx - 1] - b));
        }

        return (int)((sum - bestGain + mod) % mod);
    }
}