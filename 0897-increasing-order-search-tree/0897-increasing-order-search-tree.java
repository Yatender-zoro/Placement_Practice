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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        curr = dummy;
        solve(root);
        return dummy.right;
    }

    void solve(TreeNode root){
        if(root == null) return;

        solve(root.left);

        root.left = null;
        curr.right = root;
        curr = root;

        solve(root.right);
        
    }
}