class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();

        for (int x : a) {
            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && x < 0) {
                if (st.peek() < -x) {
                    st.pop();
                } else if (st.peek() == -x) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(x);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}