class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int cnt=0;

        for(int i =0; i<n; i++){
            for(int j =i+1; j< n; j++){
                int prod = nums[i] * nums[j];
                if(map.containsKey(prod)){
                    cnt += ( map.get(prod) * 8) ;
                    map.put(prod, map.get(prod)+1);
                }else{
                    map.put(prod,1);
                }
            }
        }
    return cnt;
    }
}