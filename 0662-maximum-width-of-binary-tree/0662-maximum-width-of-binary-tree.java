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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));

        int maxwidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int f = 0,l =0;
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                
                if(i==0){
                    f = p.idx;
                }
                if(i==size-1){
                    l = p.idx;
                }
                if(p.node.left!=null){
                    int num = 2*p.idx+1;
                    q.add(new Pair(p.node.left,num));
                }

                if(p.node.right!=null){
                    int num = 2*p.idx+2;
                    q.add(new Pair(p.node.right,num));
                }
            }
            maxwidth = Math.max(maxwidth,l-f+1);
        }
        return maxwidth;
    }
}