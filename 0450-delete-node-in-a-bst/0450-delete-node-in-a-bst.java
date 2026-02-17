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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key){
            return solve(root);
        }

        TreeNode dummy = root;
        while(root !=null){
            if(root.val>key){
                if(root.left!=null && root.left.val == key){
                    root.left = solve(root.left);
                    break;
                }
                else root = root.left;
            }
            else {
                if(root.right != null && root.right.val == key){
                    root.right = solve(root.right);
                    break;
                }
                else root = root.right;
            }
        }
        return dummy;
    }
    TreeNode solve(TreeNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode curr = root.right;
        while(curr.left != null){
            curr = curr.left;
        }

        curr.left = root.left;
        return root.right;
    }
}