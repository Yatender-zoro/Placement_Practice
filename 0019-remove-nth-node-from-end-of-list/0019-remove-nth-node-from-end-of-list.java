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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l =0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            l++;
        }
        int sp = l-n+1;

        if(sp==1) return head.next;
        ListNode curr = head;

        for(int i=1;i<sp-1;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
        // ListNode c = head;
        // int l = 0;
        // while(c != null){
        //     l++;
        //     c = c.next;
        // }
        // if( l == 1 || l == n){
        //     return head.next;
        // }

        // l = l - n + 1;
        // ListNode p = head;
        // ListNode cu = p.next;
        // if(l == 0 ){
        //     return head.next;
        // }
        // else if(l ==1){
        //     p.next = c.next;
        //     c.next = null;
        //     return head;
        // }
        // else{
        //     while(l!=2){
        //         p = p.next;
        //         cu = cu.next;
        //         l--;
        //     }
        //     p.next = cu.next;
        //     cu.next = null;
        // }
        // return head;
    }
}