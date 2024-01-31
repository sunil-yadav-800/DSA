class Solution {
    public int maxProfit(int[] prices) {
        /*
        int[][] dp = new int[prices.length+2][2];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(prices,0,1,dp);
        */
        return Tabulation(prices);
    }
    private int solve(int[] prices, int i, int buy, int[][] dp)
    {
        if(i>=prices.length)
        {
            return 0;
        }
        if(dp[i][buy] !=-1)
        {
            return dp[i][buy];
        }
        if(buy == 1)
        {
            int b = -prices[i] + solve(prices,i+1,0,dp);
            int nb = 0+solve(prices,i+1,1,dp);
            return dp[i][buy] = Math.max(b,nb);
        }
        else
        {
            int s = prices[i] + solve(prices,i+2,1,dp);
            int ns = 0+solve(prices,i+1,0,dp);
            return dp[i][buy] = Math.max(s,ns);
        }
    }
    private int Tabulation(int[] prices)
    {
        int[][] dp = new int[prices.length+2][2];
        //base case
        dp[dp.length-1][0]=0;
        dp[dp.length-1][1]=0;
        dp[dp.length-2][0]=0;
        dp[dp.length-2][1]=0;
        
        for(int i=dp.length-3;i>=0;i--)
        {
            for(int buy=0;buy<2;buy++)
            {
                if(buy == 1)
                {
                    int b = -prices[i] + dp[i+1][0];
                    int nb = 0+dp[i+1][1];
                    dp[i][buy] = Math.max(b,nb);
                }
                else
                {
                    int s = prices[i] + dp[i+2][1];
                    int ns = 0+dp[i+1][0];
                    dp[i][buy] = Math.max(s,ns);
                }
            }
        }
        return dp[0][1];
    }
}