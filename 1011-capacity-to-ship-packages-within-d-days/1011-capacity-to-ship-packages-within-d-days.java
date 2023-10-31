class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum=0;
        int min=weights[0];
        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            min=Math.min(weights[i],min);
        }
        int low=min;
        int high=sum;
        int ans=0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(IsPossible(weights,mid,days))
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
    
    public boolean IsPossible(int[]arr,int maxValue,int days)
    {
        int value=0;
        int d=1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>maxValue)
            {
                return false;
            }
            if(arr[i]+value>maxValue)
            {
                d++;
                value=arr[i];
            }
            else
            {
                value+=arr[i];
            }
        }
        if(d<=days)
            return true;
        else
            return false;
        
    }
}