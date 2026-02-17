/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev=null;
    TreeNode first = null;
    TreeNode sec = null;

    void solve(TreeNode root){
        if(root == null) return;

        solve(root.left);
        if(prev!=null && prev.val > root.val){
            if(first == null) first = prev;
            sec = root;
        }
        prev = root;
        solve(root.right);
    }
    public void recoverTree(TreeNode root) {
       solve(root);
       int t = first.val;
       first.val = sec.val;
       sec.val = t;
    }
}