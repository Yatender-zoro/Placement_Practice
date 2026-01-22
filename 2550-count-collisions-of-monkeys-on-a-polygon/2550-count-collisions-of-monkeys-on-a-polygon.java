class Solution {
    public int monkeyMove(int n) {
        int mod = 1000000007;

        long total = pow(2,n,mod);
        return (int)((total - 2 + mod) % mod);
    }
    public long pow(long base,int n,int mod){
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = res * base % mod; // bitwise
            base = base * base % mod;
            n >>= 1; // bitwise
        }
        return res;
    }

}