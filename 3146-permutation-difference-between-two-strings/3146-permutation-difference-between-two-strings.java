class Solution {
    public int findPermutationDifference(String s, String t) {

        HashMap<Character,Integer> ts = new HashMap<>();
        for(int i=0;i<t.length();i++) ts.put(t.charAt(i),i);

        int sum =0;

        for(int i=0;i<s.length();i++){
            sum+=Math.abs(i-ts.get(s.charAt(i)));
        }
        return sum;
    }
}