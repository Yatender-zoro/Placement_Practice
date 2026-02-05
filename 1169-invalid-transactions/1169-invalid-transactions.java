class Solution {
    public List<String> invalidTransactions(String[] t) {
         int n = t.length;
        List<String> ans = new ArrayList<>();
        String[][] arr = new String[n][4];

        
        for (int i = 0; i < n; i++) {
            arr[i] = t[i].split(",");
        }

        for (int i = 0; i < n; i++) {
            boolean invalid = false;
            int time1 = Integer.parseInt(arr[i][1]);
            int amt1  = Integer.parseInt(arr[i][2]);

          
            if (amt1 > 1000) invalid = true;

           
            for (int j = 0; j < n && !invalid; j++) {
                if (i == j) continue;

                if (arr[i][0].equals(arr[j][0])) {
                    int time2 = Integer.parseInt(arr[j][1]);

                    if (Math.abs(time1 - time2) <= 60 &&
                        !arr[i][3].equals(arr[j][3])) {
                        invalid = true;
                    }
                }
            }

            if (invalid) ans.add(t[i]);
        }
        return ans;
    }
}