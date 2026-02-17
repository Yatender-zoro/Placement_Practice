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
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        makeArray(root,arr);

        
        return makeTree(arr,0,arr.size()-1);
    }

     TreeNode makeTree(List<Integer> arr,int st,int en){
        if(st>en) return null;
        int mid = (st+en)/2;

        TreeNode node = new TreeNode(arr.get(mid));

        node.left = makeTree(arr, st, mid-1);
        node.right = makeTree(arr, mid+1, en);
        return node; 
    }
    void makeArray(TreeNode root,List<Integer> arr){
        if(root == null) return;

        makeArray(root.left,arr);
        arr.add(root.val);
        makeArray(root.right,arr);
    }
}