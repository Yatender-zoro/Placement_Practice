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
    int ans = 0;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        solve(root);
        return ans;
    }

    void solve(TreeNode root){
        if(root == null) return;
        

        solve(root.left);
        k--;
        if(k==0){
            ans = root.val;
            return;
        }
        solve(root.right);

        
    }
}