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
    public TreeNode pruneTree(TreeNode root) {
        solve( root);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root;
        
    }

    public int solve(TreeNode root){
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);
        if(l == 0 ){
            root.left = null;
            
        }
        if(r == 0){
            root.right = null;
        }

        if(l!=0){
            return l;
        }
        if(r!=0) return r;

        return root.val;
    }
}