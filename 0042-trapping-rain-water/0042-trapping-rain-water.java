class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();

        int[] lg = new int[n];
        int[] rg = new int[n];

        int maxi = 0;
        for(int i=0;i<n;i++){
            if(height[i]<maxi){
                lg[i] = maxi;
            }
            maxi = Math.max(maxi,height[i]);
        }
        maxi = 0;
        for(int i=n-1;i>=0;i--){
            if(height[i]<maxi){
                rg[i] = maxi;
            }
            maxi = Math.max(maxi,height[i]);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int mini = Math.min(lg[i],rg[i]);
            if(mini-height[i]>0) ans+=mini-height[i];
        }
        return ans;
    }
}