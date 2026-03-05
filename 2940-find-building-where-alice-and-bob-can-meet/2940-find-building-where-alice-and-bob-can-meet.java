import java.util.*;

class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        void build(int[] arr, int idx, int l, int r) {
            if (l == r) {
                tree[idx] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(arr, 2 * idx + 1, l, mid);
            build(arr, 2 * idx + 2, mid + 1, r);
            tree[idx] = Math.max(tree[2 * idx + 1], tree[2 * idx + 2]);
        }

        int queryMax(int idx, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return -1;
            if (ql <= l && r <= qr) return tree[idx];
            int mid = (l + r) / 2;
            return Math.max(
                queryMax(2 * idx + 1, l, mid, ql, qr),
                queryMax(2 * idx + 2, mid + 1, r, ql, qr)
            );
        }

        int findFirstGreater(int idx, int l, int r, int start, int val) {
            if (r < start || tree[idx] <= val) return -1;
            if (l == r) return l;
            int mid = (l + r) / 2;
            int left = findFirstGreater(2 * idx + 1, l, mid, start, val);
            if (left != -1) return left;
            return findFirstGreater(2 * idx + 2, mid + 1, r, start, val);
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        SegmentTree st = new SegmentTree(heights);
        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (a == b) {
                ans[i] = a;
                continue;
            }

            int left = Math.min(a, b);
            int right = Math.max(a, b);

            if (heights[left] < heights[right]) {
                ans[i] = right;
            } else {
                ans[i] = st.findFirstGreater(0, 0, n - 1, right + 1, Math.max(heights[a], heights[b]));
            }
        }

        return ans;
    }
}