class Solution {
    public int minOperations(int n) {
        int count = 0;

        while (n > 0) {
            int lowbit = n & -n;  // lowest power of 2 in n
            
            if ((n & (lowbit << 1)) != 0) {
                n += lowbit;   // merge block
            } else {
                n -= lowbit;   // remove single bit
            }
            count++;
        }

        return count;
    }
}