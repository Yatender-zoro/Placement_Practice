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
    HashMap<Integer,Integer> pos = new HashMap<>();
    int k;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.k = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            pos.put(inorder[i],i);
        }

        return makeTree(postorder,0,postorder.length-1);
    }

    public TreeNode makeTree(int[] postorder,int left, int right){

        if(left>right) return null;

        int val = postorder[k--];
        TreeNode root = new TreeNode(val);

        int idx = pos.get(val);
        root.right = makeTree(postorder,idx+1,right);
        root.left = makeTree(postorder,left,idx-1);

        return root;
    }
}