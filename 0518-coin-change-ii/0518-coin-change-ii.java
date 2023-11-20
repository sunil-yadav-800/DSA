class Solution {
    public int change(int amount, int[] coins) {
        /*
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(coins,coins.length-1,amount,dp);
        */
        return solve2(coins,amount);
    }
    private int solve(int[] coins, int idx, int amount, int[][] dp)
    {
        if(idx == 0)
        {
            if(amount%coins[idx]==0)
                return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1)
            return dp[idx][amount];
        int take = 0;
        if(amount-coins[idx]>=0)
        {
            take = solve(coins,idx,amount-coins[idx],dp);
        }
        int notTake = solve(coins,idx-1,amount,dp);
        return dp[idx][amount] = take+notTake;
    }
    private int solve2(int[] coins, int target)
    {
        int[][] dp = new int[coins.length][target+1];
        //base case
        for(int amount=0;amount<=target;amount++)
        {
            dp[0][amount]=amount%coins[0]==0?1:0;
        }
        for(int idx=1;idx<coins.length;idx++)
        {
            for(int amount=0;amount<=target;amount++)
            {
                int take = 0;
                if(amount-coins[idx]>=0)
                {
                    take = dp[idx][amount-coins[idx]];
                }
                int notTake = dp[idx-1][amount];
               dp[idx][amount] = take+notTake;
            }
        }
        return dp[coins.length-1][target];
    }
}