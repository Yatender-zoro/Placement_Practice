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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        makeAns(ans,map,root);
        return ans;
    }

    public String makeAns(List<TreeNode> ans,HashMap<String,Integer> map,TreeNode root){
        if(root == null) return "N";
       
        String s = root.val + "," + makeAns(ans,map,root.left) + "," + makeAns(ans,map,root.right);
        
        int freq = map.getOrDefault(s, 0);

        if (freq == 1) {   
            ans.add(root);
        }

        map.put(s, freq + 1);
        return s;
    }
}