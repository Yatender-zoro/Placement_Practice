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
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        int max = root.val,min = root.val;
        solve(root,max,min);      
        return ans;
    }

    public void solve(TreeNode root,int max,int min){
        ans = Math.max(Math.abs(max-min),ans);
        if(root.left!=null)
            solve(root.left,Math.max(max,root.left.val),Math.min(min,root.left.val));
        if(root.right!=null)
            solve(root.right,Math.max(max,root.right.val),Math.min(min,root.right.val));
        
        return;
    }
}