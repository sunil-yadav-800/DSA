class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(AllNegetive(nums))
        {
            int max=nums[0];
            for(int i=0;i<nums.length;i++)
            {
                max=Math.max(nums[i],max);
            }
            return max;
        }
        int curMax=0;
        int curMin=0;
        int maxSum=nums[0];
        int minSum=nums[0];
        int totalSum=0;
        for(int i=0;i<nums.length;i++)
        {
            curMax = Math.max(curMax,0)+nums[i];
            maxSum = Math.max(maxSum,curMax);
            curMin = Math.min(curMin,0)+nums[i];
            minSum = Math.min(curMin,minSum);
            totalSum = totalSum+nums[i];
        }
        int kad1 = maxSum;
        int kad2 = totalSum-minSum;
        return Math.max(kad1,kad2);
    }
    public boolean AllNegetive(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                return false;
            }
        }
        return true;
    }
}