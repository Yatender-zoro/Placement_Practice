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
    public List<List<String>> printTree(TreeNode root) {
        int rows = height(root);
        int col = (int)Math.pow(2,rows)-1;

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<rows;i++){
            List<String> li = new ArrayList<>();
            for(int j=0;j<col;j++){
                li.add("");
            }
            ans.add(li);
        }

        dfs(root,0,0,col-1,ans);
        return ans;
    }

    void dfs(TreeNode root,int row,int st,int en,List<List<String>> ans){
        if(root == null) return;

        int mid = (st+en)/2;
        ans.get(row).set(mid,""+root.val);
        dfs(root.left,row+1,st,mid-1,ans);
        dfs(root.right,row+1,mid+1,en,ans);
    }

    int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
}