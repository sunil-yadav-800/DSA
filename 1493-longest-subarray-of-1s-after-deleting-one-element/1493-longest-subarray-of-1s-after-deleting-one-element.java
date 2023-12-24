class Solution {
    public int longestSubarray(int[] nums) {
        int ans=0;
        int zeroCount=0;
        int start=0,end=0;
        while(end<nums.length)
        {
            if(nums[end]==0)
            {
                zeroCount++;
            }
            while(zeroCount>1)
            {
                if(nums[start]==0)
                {
                    zeroCount--;
                }
                start++;
            }
            //we will not take entire window length, we also have to delete one element
            ans=Math.max(ans,end-start);
            end++;
        }
        return ans;
    }
    public int bruteForce(int[] nums)
    {
        int ans=0;
        //this flag will tell you wheather there is zero in this array or not
        boolean zeroFlag=false;
        for(int i=0;i<nums.length;i++)
        {
            int ones=0;
            int zeros=0;
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]==1)
                {
                    ones++;
                    ans=Math.max(ans,ones);
                }
                else
                {
                    zeroFlag=true;
                    zeros++;
                }
                if(zeros>1)
                {
                    break;
                }
            }
        }
        if(!zeroFlag)
        {
            return ans-1;
        }
        return ans;
    }
}