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
    int c = 0;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        
        countgn(root,max);
        return c;
    }
    public void countgn(TreeNode root,int max){
        if(root == null) return ;
        if(root.val>=max){
            c++;
        }
        countgn(root.left,Math.max(max,root.val));
        countgn(root.right,Math.max(max,root.val));
    }
}