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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        addPath(root,"");
        return ans;
    }
    public void addPath(TreeNode root,String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(s+root.val);
            return ;
        }
        addPath(root.left,s+root.val +"->");
        addPath(root.right,s+root.val +"->");
    }
}