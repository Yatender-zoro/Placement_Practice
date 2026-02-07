class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> e = new HashMap<>();
        HashMap<Integer,Integer> o = new HashMap<>();
        int n = nums.length;
        int operation = 0;
        int evenLen = (n + 1) / 2;
        int oddLen = n/2;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                e.put(nums[i], e.getOrDefault(nums[i], 0) + 1);
            else
                o.put(nums[i], o.getOrDefault(nums[i], 0) + 1);
        }

        
        // int maxf = 0;
        // for(int x:o.keySet()){
        //     if(!e.containsKey(x)){
        //         maxf = Math.max(maxf,o.get(x));
        //     }
        // }

        // if(maxf==0){
        //     for(int x:e.keySet()){
        //         if(!o.containsKey(x)){
        //             maxf = Math.max(maxf,e.get(x));
        //         }
        //     }
        //     return (n-olen-maxf);
        // }

        
        
        // operation+= (olen-maxf);

        // maxf = 0;
        // for(int x:e.keySet()){  
        //     maxf = Math.max(maxf,e.get(x));  
        // }

        // operation+=(n-olen-maxf);
        // return operation;

         int e1 = 0, e2 = 0;
        int ev1 = -1, ev2 = -1;
        for (int x : e.keySet()) {
            int f = e.get(x);
            if (f > e1) {
                e2 = e1; ev2 = ev1;
                e1 = f;  ev1 = x;
            } else if (f > e2) {
                e2 = f; ev2 = x;
            }
        }

        // find top 2 in odd
        int o1 = 0, o2 = 0;
        int ov1 = -1, ov2 = -1;
        for (int x : o.keySet()) {
            int f = o.get(x);
            if (f > o1) {
                o2 = o1; ov2 = ov1;
                o1 = f;  ov1 = x;
            } else if (f > o2) {
                o2 = f; ov2 = x;
            }
        }

        if (ev1 != ov1) {
            return (evenLen - e1) + (oddLen - o1);
        }

        return Math.min(
            (evenLen - e1) + (oddLen - o2),
            (evenLen - e2) + (oddLen - o1)
        );
    }
}