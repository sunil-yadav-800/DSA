class Solution {
    public int minOperations(int[] nums, int x) {
        int left=0;
        int sum=0;
        for(int num: nums)
        {
            sum+=num;
        }
        int target = sum-x;
        int curr_sum=0;
        int ans=-1;
        for(int right=0;right<nums.length;right++)
        {
            curr_sum+=nums[right];
            while(left<=right && curr_sum>target)
            {
                curr_sum-=nums[left];
                left++;
            }
            if(curr_sum == target)
            {
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans==-1?-1:nums.length-ans;
    }
}