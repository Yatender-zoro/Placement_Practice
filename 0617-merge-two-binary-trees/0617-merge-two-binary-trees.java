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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return solve(root1,root2);
    }
    public TreeNode solve(TreeNode a, TreeNode b){
        if (a == null) return b;
        if (b == null) return a;

        a.val += b.val;
         a.left = solve(a.left, b.left);
        a.right = solve(a.right, b.right);
        return a;
    }
}