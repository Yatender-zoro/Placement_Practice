class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long ans = (pow(5, evenPos) * pow(4, oddPos)) % MOD;
        return (int) ans;
    }

    private long pow(long base, long exp) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2);
        long res = (half * half) % MOD;
        if (exp % 2 == 1) res = (res * base) % MOD;
        return res;
    }
}
