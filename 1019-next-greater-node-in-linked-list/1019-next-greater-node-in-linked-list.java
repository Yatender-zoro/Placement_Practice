/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode cnt = head;
        int c = 0;
        while(cnt!=null){
            cnt = cnt.next;
            c++;
        }
        int k  = 0;
        int[] ans = new int[c];

        Stack<int[]> st = new Stack<>();
        ListNode it = head;
        int idx = 0;
        while(it!=null){

            while(!st.isEmpty() && st.peek()[1]<it.val){
                int[] t = st.pop();

                ans[t[0]] = it.val;
            }
            st.push(new int[]{idx++,it.val});
            it = it.next;
        }

        return ans;
    }
}