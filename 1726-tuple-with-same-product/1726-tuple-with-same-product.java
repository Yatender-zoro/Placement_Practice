class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int pairs = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int p = nums[i]*nums[j];
                map.put(p,map.getOrDefault(p,0)+1);
            }
        }

        for(Integer x:map.keySet()){
            int f = map.get(x);
            pairs+=(f*(f-1)/2);
        }
        return pairs*8;
    }
}