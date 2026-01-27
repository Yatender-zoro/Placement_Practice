class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sum=0;
        while(tickets[k]>0)
        {
            for(int i=0; i<tickets.length; i++)
            {
                if(tickets[i]>0)
                {
                    if(tickets[k]<=0)return sum;
                tickets[i]--;
                sum++;
                }
            }
            
        }
        return sum;
    }
}