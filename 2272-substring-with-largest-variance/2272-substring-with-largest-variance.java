class Solution {
    public int largestVariance(String s) {
        int res = 0;

        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                if (a == b) continue;

                res = Math.max(res, kadane(s, a, b));
                res = Math.max(res, kadane(new StringBuilder(s).reverse().toString(), a, b));
            }
        }
        return res;
    }

    private int kadane(String s, char a, char b) {
        int diff = 0;
        int hasB = 0;
        int best = 0;

        for (char c : s.toCharArray()) {
            if (c == a) diff++;
            if (c == b) {
                diff--;
                hasB = 1;
            }

            if (hasB == 1)
                best = Math.max(best, diff);

            if (diff < 0) {
                diff = 0;
                hasB = 0;
            }
        }
        return best;
    }
}
