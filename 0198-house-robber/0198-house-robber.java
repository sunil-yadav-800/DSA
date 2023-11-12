class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return Memo(nums,nums.length-1,dp);
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
}