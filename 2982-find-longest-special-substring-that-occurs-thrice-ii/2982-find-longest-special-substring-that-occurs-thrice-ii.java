class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<26;i++)
        list.add(new ArrayList<>());

        int cl = 1;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                cl++;
            }
            else{
                list.get(s.charAt(i)-'a').add(cl);
                cl = 1;
            }
        }

        list.get(s.charAt(n-1)-'a').add(cl);
        
        int ans = -1;
        for(int i=0;i<26;i++){
            ArrayList<Integer> blocks = list.get(i);
            if (blocks.isEmpty()) continue;

            blocks.sort((a, b) -> b - a);

            int total = 0;
            for (int x : blocks) total += x;

            if (total >= 3)
                ans = Math.max(ans, 1);
                
            if (blocks.get(0) >= 3)
                ans = Math.max(ans, blocks.get(0) - 2);
            if (blocks.size() >= 2){
                int cand = (blocks.get(0) + blocks.get(1) - 1) / 2;
                if (cand >= 1)  
                    ans = Math.max(ans, cand);
            }
                
            if (blocks.size() >= 3)
                ans = Math.max(ans, blocks.get(2));
        }
        return ans;
    }
}