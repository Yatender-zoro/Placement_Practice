class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        boolean f = false;
        if(n.charAt(0)=='-'){
            sb.append('-');
            for(int i=1;i<n.length();i++){
                if(n.charAt(i)-'0'>x && f==false){
                    sb.append(x);
                    sb.append(n.charAt(i));
                    f = true; 
                }
                else
                sb.append(n.charAt(i));
            }
            if(!f){
                sb.append(x);
            }
        }
        else{
            for(int i=0;i<n.length();i++){
                if(n.charAt(i)-'0'<x && f==false){
                    sb.append(x);
                    sb.append(n.charAt(i));
                    f = true;
                }
                else
                sb.append(n.charAt(i));
            }
            if(!f){
                sb.append(x);
            }
        }
        return sb.toString();
    }
}