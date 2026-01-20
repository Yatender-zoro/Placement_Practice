class Solution {
    public int numTeams(int[] ratings) {
        int n = ratings.length;
        int c = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                boolean f = ratings[i]<ratings[j];
                for(int k=j+1;k<n;k++){
                    if((ratings[k]>ratings[j])==f) c++;
                }
            }
        }
        return c;
    }
}