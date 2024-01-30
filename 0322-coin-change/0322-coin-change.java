class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        int res = solve1(coins,0,amount,dp);
        */
        int res = solve2(coins,amount);
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
    private int solve2(int[] arr, int totalAmount)
    {
        int[][] dp = new int[arr.length+1][totalAmount+1];
        //fill base case
        for(int row=0;row<dp.length;row++)
        {
            dp[row][0]=0;
        }
        for(int col=0;col<dp[0].length;col++)
        {
            dp[dp.length-1][col]=Integer.MAX_VALUE;
        }
        for(int idx = dp.length-2; idx>=0;idx--)
        {
            for(int amount = 1; amount<=totalAmount; amount++)
            {
                int take = Integer.MAX_VALUE;
                if(amount-arr[idx]>=0)
                {
                   take = dp[idx][amount-arr[idx]];
                }
                if(take != Integer.MAX_VALUE)
                {
                    take+=1;
                }
               int notTake = dp[idx+1][amount];
               dp[idx][amount] = Math.min(take,notTake);
            }
        }
        return dp[0][totalAmount];
    }
}