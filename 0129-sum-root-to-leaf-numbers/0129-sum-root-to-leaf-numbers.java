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
    public int sumNumbers(TreeNode root) {
        return solve(root,"");
    }

    public int solve(TreeNode root,String s){
        if(root == null) return Integer.parseInt(s);
        s = s+root.val;
        if(root.left == null && root.right == null ) return Integer.parseInt(s);
        int l =0,r =0;
        if(root.left!=null)
            l = solve(root.left,s);
        if(root.right !=null)
            r = solve(root.right,s);
        return l+r;
    }
}