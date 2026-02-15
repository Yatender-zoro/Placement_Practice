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
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    TreeNode startNode;

    public int amountOfTime(TreeNode root, int start) {
        buildParent(root,start);

       
        HashSet<Integer> infected = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(startNode);
        infected.add(startNode.val);

        int time = -1;
        while(!q.isEmpty()){

            int size = q.size();

            while(size-->0){
                TreeNode e = q.poll();

                if(e!= null){
                    if(e.left != null && !infected.contains(e.left.val)){
                        q.add(e.left);
                        infected.add(e.left.val);
                    }

                    if(e.right != null && !infected.contains(e.right.val)){
                        q.add(e.right);
                        infected.add(e.right.val);
                    }

                    TreeNode par = parent.get(e);

                    if(par!= null && !infected.contains(par.val)){
                        q.add(par);
                        infected.add(par.val);
                    }
                }
            }
            time++;
        }
        return time;
    }

    void buildParent(TreeNode root,int start){
        if(root == null) return ;
        
        if(root.val == start)
            startNode = root;


        if(root.left!=null){
            parent.put(root.left,root);
        }
        buildParent(root.left,start);

        if(root.right!=null){
            parent.put(root.right,root);
        }
        buildParent(root.right,start);
    }
}