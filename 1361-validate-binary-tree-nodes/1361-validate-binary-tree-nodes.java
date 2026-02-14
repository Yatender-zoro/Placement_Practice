class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] p = new int[n];
        Arrays.fill(p,-1);

        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1){
                if(p[leftChild[i]]!=-1) return false;
                p[leftChild[i]] = i;
            }
            if(rightChild[i]!=-1){
                if(p[rightChild[i]]!=-1) return false;
                p[rightChild[i]] = i;
            }
        }
        
       int root = -1;
       for(int i=0;i<n;i++){
            if(p[i]==-1){
                if(root!=-1) return false;
                root = i;
            }
       }

       if(root == -1) return false;

       boolean[] vis = new boolean[n];
       if(!dfs(root,leftChild,rightChild,vis)) return false;

        for(boolean v:vis){
            if(!v) return false;
        }

        return true;
    }

    public boolean dfs(int node,int[] left,int[] right,boolean[] vis){
        if(node == -1) return true;
        if(vis[node]) return false; // cycle detected

        vis[node] = true;

        return dfs(left[node],left,right,vis) && dfs(right[node],left,right,vis);
    }
}