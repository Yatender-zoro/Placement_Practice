class Solution {
    public int maxFrequency(int[] nums, int k) {
       int n = nums.length;
        int base = 0;
        for (int x : nums) {
            if (x == k) base++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x != k) set.add(x);
        }

        int bestGain = 0;

        for (int val : set) {
            int curr = 0;
            int maxHere = 0;

            for (int x : nums) {
                int score = 0;
                if (x == val) score = 1;
                else if (x == k) score = -1;

                curr = Math.max(score, curr + score);
                maxHere = Math.max(maxHere, curr);
            }

            bestGain = Math.max(bestGain, maxHere);
        }

        return base + bestGain;
    }
}