class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int c = 0;
        // for(int i=0;i<n-2;i++){
        //     for(int j=i+1;j<n-1;j++){
        //         boolean f = ratings[i]<ratings[j];
        //         for(int k=j+1;k<n;k++){
        //             if((ratings[k]>ratings[j])==f) c++;
        //         }
        //     }
        // }
        // return c;

        for(int i=0;i<n;i++){ // i is for middle element
            int lefts=0,leftg=0;
            int rights=0,rightg = 0;

            for(int j=0;j<n;j++){
                if(j<i){
                    if(rating[j]<rating[i]){
                        lefts++;
                    }
                    else leftg++;
                }
                else if(j>i){
                    if(rating[j]>rating[i]){
                        rightg++;
                    }
                    else rights++;
                }
            }
            int total= lefts*rightg + leftg*rights;
            c+=total;
        }
        return c;
    }
}