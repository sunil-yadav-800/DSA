class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int start=0;
        int sum=0;
        for(int end=0;end<nums.length;end++)
        {
            sum+=nums[end];
            while(sum>=target)
            {
                ans=Math.min(ans,end-start+1);
                sum-=nums[start];
                start++;
            }
        }
        if(ans == Integer.MAX_VALUE)
            return 0;
        return ans;
    }
}