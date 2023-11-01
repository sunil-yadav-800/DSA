class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi=piles[0];
        for(int i=1;i<piles.length;i++)
        {
            maxi=Math.max(maxi,piles[i]);
        }
        int low=1,high=maxi;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2; //no. of banana per hour
            if(isPosible(piles,mid,h))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isPosible(int[] arr, int b, int h)
    {
        long totalHour=0;
        for(int i=0;i<arr.length;i++)
        {
            totalHour+=arr[i]/b;
            if(arr[i]%b!=0)
            {
                totalHour++;
            }
        }
        return totalHour<=h;
    }
}