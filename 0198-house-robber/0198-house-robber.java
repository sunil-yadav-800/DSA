class Solution {
    public int rob(int[] nums) {
        /*
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return Memo(nums,nums.length-1,dp);
        */
        //return Tabulation(nums);
        
        return solve(nums);
    }
    private int Memo(int[] arr, int idx, int[] dp)
    {
        if(idx<0)
        {
            return 0;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        int take = arr[idx]+Memo(arr,idx-2,dp);
        int ntake = Memo(arr,idx-1,dp);
        return dp[idx]=Math.max(take,ntake);
    }
    private int Tabulation(int[] arr)
    {
        int[] dp = new int[arr.length+2];
        //base
        dp[0]=0;
        dp[1]=0;
        
        for(int i=2;i<dp.length;i++)
        {
            int take = dp[i-2]+arr[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take,notTake);
        }
        
        return dp[dp.length-1];
    }
    private int solve(int[] nums)
    {
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}