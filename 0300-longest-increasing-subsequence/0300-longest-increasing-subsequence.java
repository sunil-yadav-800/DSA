class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0; j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(nums,0,-1,dp);
        */
        return solve2(nums);
    }
    private int solve(int[] nums, int idx, int prev, int[][] dp)
    {
        if(idx == nums.length)
        {
            return 0;
        }
        if(dp[idx][prev+1] !=-1)
        {
            return dp[idx][prev+1];
        }
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev])
        {
            take=1+solve(nums,idx+1,idx,dp);
        }
        int notTake = solve(nums,idx+1,prev,dp);
        return dp[idx][prev+1] = Math.max(take,notTake);
    }
    private int solve2(int[] nums)
    {
        int[][] dp = new int[nums.length+1][nums.length+1];
        //base case, since all cell will be zero bydefault so skip
        //other wise fill each column of last row(nums.length) with o
        
        for(int idx=nums.length-1;idx>=0;idx--)
        {
            for(int prev=nums.length-1;prev>=-1;prev--)
            {
                int take=0;
                if(prev==-1 || nums[idx]>nums[prev])
                {
                    take=1+dp[idx+1][idx+1];
                }
                int notTake = dp[idx+1][prev+1];
                dp[idx][prev+1] = Math.max(take,notTake);
            }
        }
        return dp[0][0];
        
    }
}