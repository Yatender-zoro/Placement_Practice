class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ind=0;
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums2[j]==nums1[i]){
                    ind = j;
                    break;
                }
            }
            for(int j=ind+1; j<nums2.length; j++){
                if(nums2[j]>nums1[i]){
                    nums1[i]=nums2[j];
                    break;
                }
            }
            if(nums1[i]==nums2[ind]){
                nums1[i]=-1;
            }
        }
        return nums1;
    }
}