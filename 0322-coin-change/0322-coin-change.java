class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        int res = solve1(coins,0,amount,dp);
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
    private int solve1(int[] arr, int idx, int amount, int[][] dp)
    {
        
        if(amount == 0)
            return 0;
        if(idx == arr.length)
            return Integer.MAX_VALUE;
        if(dp[idx][amount]!=-1)
        {
            return dp[idx][amount];
        }
        int take = Integer.MAX_VALUE;
        if(amount-arr[idx]>=0)
        {
             take = solve1(arr,idx,amount-arr[idx],dp);
            if(take != Integer.MAX_VALUE)
            {
                take+=1;
            }
        }
        int notTake = solve1(arr,idx+1,amount,dp);
        return dp[idx][amount] = Math.min(take,notTake);
    }
}