class Solution {
    public boolean canPartition(int[] nums) {
        /*
        int sum=0;
        for(int num: nums)
        {
            sum+=num;
        }
        if(sum%2!=0)
        {
            return false;
        }
        int target=sum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        return solve1(nums,nums.length-1,target,dp);
        */
        return solve2(nums);
    }
    private boolean solve1(int[] arr, int idx, int target, boolean[][] dp)
    {
        //base case
        if(target == 0)
        {
            return true;
        }
        if(idx == 0)
        {
            if(arr[0] == target)
                return true;
            return false;
        }
        if(dp[idx][target]!=false)
        {
            return true;
        }
        boolean take = false;
        if(target-arr[idx]>=0)
        {
            take = solve1(arr,idx-1,target-arr[idx],dp);
        }
        boolean notTake = solve1(arr,idx-1,target,dp);
        return dp[idx][target] = (take || notTake);
    }
    private boolean solve2(int[] nums)
    {
        int sum=0;
        for(int num: nums)
        {
            sum+=num;
        }
        if(sum%2!=0)
        {
            return false;
        }
        int tar=sum/2;
        boolean[][] dp = new boolean[nums.length][tar+1];
        
        //base case
        for(int row=0;row<dp.length;row++)
        {
            dp[row][0]=true;
        }
        if(nums[0]<=tar)
        {
        dp[0][nums[0]]=true;
        }
        
        for(int idx=1;idx<nums.length;idx++)
        {
            for(int target=1;target<=tar;target++)
            {
                boolean take = false;
                if(target-nums[idx]>=0)
                {
                    take = dp[idx-1][target-nums[idx]];
                }
                boolean notTake = dp[idx-1][target];
                dp[idx][target] = (take | notTake);
            }
        }
        return dp[nums.length-1][tar];
    }
}