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

    public int amountOfTime(TreeNode root, int start) {
        buildParent(root);

        TreeNode node = findStart(root,start);
        HashSet<Integer> infected = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);
        infected.add(node.val);

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

    TreeNode findStart(TreeNode root, int start){
        if(root == null ) return null;
        if(root.val == start) return root;

        TreeNode l = findStart(root.left,start);
        TreeNode r = findStart(root.right,start);

        return l==null?r:l;
    }

    void buildParent(TreeNode root){
        if(root == null) return ;

        if(root.left!=null){
            parent.put(root.left,root);
        }
        buildParent(root.left);

        if(root.right!=null){
            parent.put(root.right,root);
        }
        buildParent(root.right);
    }
}