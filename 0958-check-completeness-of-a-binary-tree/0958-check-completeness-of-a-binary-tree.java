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
    //     TreeNode root;
    //     int idx;
    //     Pair(TreeNode root,int idx){
    //         this.root = root;
    //         this.idx = idx;
    //     }
    // }
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean seenNull = false;

        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur == null){
                seenNull = true;
            } else {
                if(seenNull) return false;
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;
        // Queue<Pair> q = new LinkedList<>();

        // q.add(new Pair(root,0));

        // int lvl = 0;
        // while(!q.isEmpty()){
        //     List<Integer> li = new ArrayList<>();
            
        //     int size = q.size();
        
        //     for(int i=0;i<size;i++){
        //         Pair node = q.poll();

        //         li.add(node.idx);
        //         if(node.root.left!= null) q.add(new Pair(node.root.left,2*node.idx+1));
        //         if(node.root.right!= null) q.add(new Pair(node.root.right,2*node.idx+2));
        //     }
            
        //     int expected = (1<<lvl);  
        //     if(li.size()!=expected){
        //         int first = expected - 1;
        //         for(int x:li){
        //             if(x == first){
        //                 first++;
        //             }
        //             else{
        //                 return false;
        //             }
        //         }
        //         if(!q.isEmpty()) return false;
        //     }
        //     lvl++;
        // }
        // return true;
    }
}