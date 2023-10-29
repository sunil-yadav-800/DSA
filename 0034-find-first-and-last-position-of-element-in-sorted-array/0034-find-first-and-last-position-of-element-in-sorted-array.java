class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        ans[0] = First(nums,target);
        ans[1] = Last(nums,target);
        
        return ans;
        
    }
    public int First(int[]arr, int target)
    {
        int start=0,end=arr.length-1,ans=-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            
            if(arr[mid]==target)
            {
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return ans;
    }
    
    public int Last(int[]arr,int target)
    {
        int start=0,end=arr.length-1,ans=-1;
        
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==target)
            {
                ans=mid;
                start=mid+1;
            }
            else if(arr[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return ans;
    }
}