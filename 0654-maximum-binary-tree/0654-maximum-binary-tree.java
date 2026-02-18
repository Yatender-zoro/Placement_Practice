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
    int n;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.n = nums.length;        
        return solve(nums,0,n-1);
    }

    TreeNode solve(int[]nums,int st,int en){

        if(st>en) return null;
        int p = -1;
        int maxi = -1;

        for(int i=st;i<=en;i++){
            if(nums[i]>maxi){
                maxi = nums[i];
                p = i;
            }
        }
        TreeNode root = new TreeNode(maxi);
        root.left = solve(nums,st,p-1);
        root.right = solve(nums,p+1,en);
        return root;
    }
}