class Solution {
    public int rob(int[] nums) {
        /*
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return Memo(nums,nums.length-1,dp);
        */
        if(nums.length==1)
        {
            return nums[0];
        }
        int first = Tabulation(nums,0,nums.length-2);
        int second = Tabulation(nums,1,nums.length-1);
        return Math.max(first,second);
    }
    
    private int Tabulation(int[] arr, int start, int end)
    {
        int[] dp = new int[arr.length+1];
        dp[start]=arr[start];
        for(int i=start+1;i<=end;i++)
        {
            int take = arr[i];
            if(i>1)
            {
                take+=dp[i-2];
            }
            int ntake = dp[i-1];
            dp[i]=Math.max(take,ntake);
        }
        return dp[end];
    }
}