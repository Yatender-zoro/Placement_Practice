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
    ArrayList<Integer> list;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();


        list = new ArrayList<>();

        makeArray(root);

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        int m = arr.length;

        for(int q : queries){
            int pos = Arrays.binarySearch(arr,q);

            List<Integer> temp = new ArrayList<>();
            if(pos>=0){
                temp.add(arr[pos]);
                temp.add(arr[pos]);
               
            }
            else{
                pos = -(pos + 1);
                int lower = (pos - 1 >= 0) ? arr[pos - 1] : -1;
                int higher = (pos < m) ? arr[pos] : -1;

                temp.add(lower);
                temp.add(higher);

            }
            ans.add(temp);
        }
        return ans;
        
    }

    public void makeArray(TreeNode root){
        if(root == null) return;
        makeArray(root.left);
        list.add(root.val);
        makeArray(root.right);
    }
}