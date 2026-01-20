class Solution {
    public int maxSumMinProduct(int[] nums) {
        int mod=1000000007;
        int n = nums.length;
        long []p = new long[n+1];

        for(int i=0;i<n;i++){
            p[i+1] = p[i]+nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            left[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            right[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        long ans = 0;
        for(int i=0;i<n;i++){
            long sum = p[right[i]]-p[left[i]+1];
            long prod = sum*nums[i];
            ans = Math.max(prod,ans);
        }

        return (int)(ans%mod);
    }
}

// class Solution {
//     public int maxSumMinProduct(int[] nums) {
//         int n=nums.length;
//         int mod=1000000007;
//         long prefix[]=new long[n+1];
//         for(int i=0;i<n;i++){
//             prefix[i+1]=prefix[i]+nums[i];
//         }
//         int left[]=new int[n];
//         int right[]=new int[n];
//         Stack<Integer> st=new Stack<>();
//         for(int i=0;i<n;i++){
//             while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
//                 st.pop();
//             }
//             left[i]=st.isEmpty()?-1:st.peek();
//             st.push(i);
//         }
//         st.clear();
//         for(int i=n-1;i>=0;i--){
//             while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
//                 st.pop();
//             }
//             right[i]=st.isEmpty()?n:st.peek();
//             st.push(i);
//         }
//         long ans=0;
//         for(int i=0;i<n;i++){
//             long maxSum=prefix[right[i]]-prefix[left[i]+1];
//             long prod=nums[i]*maxSum;
//             ans=Math.max(ans,prod);
//         }
//         return (int)(ans%mod);
//     }
// }