class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> para = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                para.push(i);
            }
            else if(c=='*'){
                star.push(i);
            }
            else{
                if(!para.isEmpty()){
                    para.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }else return false;
            }
        }
        while (!para.isEmpty() && !star.isEmpty()) {
            if (para.peek() > star.peek()) return false;
                para.pop();
                star.pop();
        }

        return para.isEmpty();
    }
}