class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return Solve1(nums,0,target,dp);
    }
    private int Solve1(int[] arr, int idx, int target, int[][] dp)
    {
        //base case
        if(target == 0)
        {
            return 1;
        }
        if(idx == arr.length)
        {
            return 0;
        }
        if(dp[idx][target] !=-1)
            return dp[idx][target];
        
        int take = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(target-arr[i]>=0)
            {
                take = take + Solve1(arr,i,target-arr[i],dp);
            }
        }
        return dp[idx][target] = take;
    }
}