class Solution {
    public int splitArray(int[] nums, int k) {
        int mini = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            mini = Math.min(mini,nums[i]);
            sum+=nums[i];
        }
        int low=mini,high=sum;
        int ans=0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(nums,mid,k))
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
    public boolean isPossible(int[] nums, int mid, int k)
    {
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>mid)
            {
                return false;
            }
            if(sum+nums[i]>mid)
            {
                count++;
                sum=nums[i];
            }
            else
            {
                sum+=nums[i];
            }
        }
        return count<=k;
    }
}