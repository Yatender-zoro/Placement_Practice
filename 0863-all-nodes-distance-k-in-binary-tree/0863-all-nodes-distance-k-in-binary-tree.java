/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        mark(root);

        List<Integer> ans = new ArrayList<>();

        HashSet<Integer> vis = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);
        vis.add(target.val);

        int d = 0;
        while(!q.isEmpty()){
            int n = q.size();

            while(n-->0){
                
                if(d>k) return ans;
                TreeNode ele = q.poll();
                if(d == k){
                    ans.add(ele.val);
                }
                if(ele!=null){
                    if(ele.left!=null && !vis.contains(ele.left.val)){
                        vis.add(ele.left.val);
                        q.add(ele.left);
                    }

                    if(ele.right!=null && !vis.contains(ele.right.val)){
                        vis.add(ele.right.val);
                        q.add(ele.right);
                    }

                    TreeNode par = parent.get(ele);
                    if(par!= null && !vis.contains(par.val)){
                        vis.add(par.val);
                        q.add(par);
                    }
                }
                
            }
            
            d++;
        }
        return ans;
    }

    public void mark(TreeNode root){
        if(root == null) return;

        if(root.left!=null)
            parent.put(root.left,root);
        mark(root.left);

        if(root.right!=null)
            parent.put(root.right,root);
        mark(root.right);
    }
}