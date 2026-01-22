class Solution {
    public String removeKdigits(String num, int k) {
         Deque<Character> st = new ArrayDeque<>();

        for(char c:num.toCharArray()){
            while(!st.isEmpty() && c<st.peekLast() && k>0){
                st.pollLast();
                k--;
            }
            st.addLast(c);
        }

        while(k > 0 && !st.isEmpty()) {
            st.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c:st){
            if(sb.length()==0 && c=='0') continue;
            sb.append(c);
        }
        return sb.length()==0?"0":sb.toString();
    }
}