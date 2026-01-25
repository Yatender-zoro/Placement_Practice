class StockSpanner {
    private Deque<int[]> st;
    private int idx;
    public StockSpanner() {
        st = new ArrayDeque<>();
        idx = 0;
    }
    
    public int next(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int ans = st.isEmpty() ? idx + 1 : idx - st.peek()[1];
        st.push(new int[]{price, idx});
        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */