class Solution {
    public int maxSubArray(int[] nums) {
        return sum(nums);
    }
    public int sum(int[] nums)
    {
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            ans=Math.max(ans,sum);
            if(sum<0)
            {
                sum=0;
            }
        }
        return ans;
    }
}