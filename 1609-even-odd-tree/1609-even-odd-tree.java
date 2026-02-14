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
    // class Pair{
    //     TreeNode node;
    //     int lvl;
    //     Pair(TreeNode node,int lvl){
    //         this.node = node;
    //         this.lvl = lvl;
    //     }
    // }
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int lvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            int prev = (lvl % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode ele = q.poll();
                
                if((lvl & 1)==0){
                    if(((ele.val & 1)==0) || prev>=ele.val){
                        return false;
                    }
                }

                else{
                    if(((ele.val & 1)==1) || prev<=ele.val){
                        return false;
                    }
                }
                prev = ele.val;
                if(ele.left != null) q.add(ele.left);
                if(ele.right != null) q.add(ele.right);
            }
            lvl++;

        }
        return true;
    }
}