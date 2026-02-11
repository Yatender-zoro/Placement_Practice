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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        countSum(root,map);

        int maxi = 0;
        int len = 0;
        for(int x:map.values()){
            if(x>maxi){
                maxi = x;
                len = 1;
            }
            else if(x==maxi) len++;
        }

        int[] ans = new int[len];
        int k=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(it.getValue()==maxi){
                ans[k++] = it.getKey();
            }
        }
        return ans;
    }

    public int countSum(TreeNode root, HashMap<Integer,Integer> map){
        if(root == null) return 0;
        int sum = root.val + countSum(root.left,map) + countSum(root.right,map);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}