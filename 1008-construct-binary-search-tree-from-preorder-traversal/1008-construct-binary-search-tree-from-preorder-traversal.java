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
    int i = 0;
   
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,1005,-1);
       
    }
    TreeNode solve(int[] preorder,int max,int min){
        if(i==preorder.length || preorder[i]>max || preorder[i]<min) return null;

        TreeNode root = new TreeNode(preorder[i++]);

        root.left = solve(preorder,root.val,min);
       
        root.right = solve(preorder,max,root.val);

        return root;
    }
}