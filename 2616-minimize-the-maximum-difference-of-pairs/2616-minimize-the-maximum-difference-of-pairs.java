class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low=0,high=nums[nums.length-1]-nums[0];
        int ans=0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(isPosible(nums,mid,p))
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
    private boolean isPosible(int[]arr, int d, int p)
    {
        int pairs=0;
        for(int i=1;i<arr.length;i++)
        {
            if((arr[i]-arr[i-1])<=d)
            {
                pairs++;
                i++;
            }
        }
        return pairs>=p;
    }
}