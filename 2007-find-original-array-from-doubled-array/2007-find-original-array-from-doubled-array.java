class Solution {
    public int[] findOriginalArray(int[] changed) {

        int m = changed.length;
        if (m % 2 != 0) return new int[]{};

        // HashMap<Integer,Integer> map = new HashMap<>();
        // int n = changed.length;
        // int[] ans = new int[n/2];
        // Arrays.fill(ans,-1);

        // Arrays.sort(changed);

        // for (int e : changed)
        //     map.put(e, map.getOrDefault(e, 0) + 1);
        
        

        // int k=0;
        
        // for(int x:changed){
        //     if (map.get(x) == 0) continue;
        //         if(x==0){
        //             if(map.get(0)>=2){
        //                 ans[k++] = 0;
        //                 map.put(0,map.get(0)-2);
        //                 continue;
        //             }
        //             else return new int[]{};
        //         }
        //         if (!map.containsKey(2 * x) || map.get(2 * x) == 0)
        //         return new int[]{};
        //         ans[k++] = x;
        //         map.put(x, map.get(x) - 1);
        //         map.put(2 * x, map.get(2 * x) - 1);
        //     }
        
        //  return k == n / 2 ? ans : new int[]{};

        
        Arrays.sort(changed);
        int max = changed[m-1];
        if (max < 0) return new int[]{};
        int[] dp = new int[max * 2 + 1];

        for(int i:changed){
            dp[i]++;
        }

        int ans[] = new int[m/2];
        int k = 0;
        if (dp[0] % 2 != 0) return new int[]{};
        while (dp[0] > 0) {
            ans[k++] = 0;
            dp[0] -= 2;
        }

        for (int x : changed) {
            if (x == 0 || dp[x] == 0) continue;

            if (2 * x >= dp.length || dp[2 * x] == 0)
                return new int[]{};

            dp[x]--;
            dp[2 * x]--;
            ans[k++] = x;
        }

        return k == m / 2 ? ans : new int[]{};
    }
}