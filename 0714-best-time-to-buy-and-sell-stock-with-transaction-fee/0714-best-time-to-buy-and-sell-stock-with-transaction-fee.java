class Solution {
    public int maxProfit(int[] prices, int fee) {
       /* 
        int[][] dp = new int[prices.length+2][2];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(prices,0,1,fee,dp);
        */
        return Tabulation(prices,fee);
    }
    private int solve(int[] prices, int i, int buy, int fee, int[][] dp)
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
            int b = -prices[i] + solve(prices,i+1,0,fee,dp);
            int nb = 0+solve(prices,i+1,1,fee,dp);
            return dp[i][buy] = Math.max(b,nb);
        }
        else
        {
            int s = prices[i] - fee + solve(prices,i+1,1,fee,dp);
            int ns = 0+solve(prices,i+1,0,fee,dp);
            return dp[i][buy] = Math.max(s,ns);
        }
    }
    private int Tabulation(int[] prices, int fee)
    {
        int[][] dp = new int[prices.length+1][2];
        //base
        dp[prices.length][0]=0;
        dp[prices.length][1]=0;
        
        for(int i = prices.length-1;i>=0;i--)
        {
            for(int buy=1;buy>=0;buy--)
            {
                if(buy == 1)
                {
                    int b = -prices[i] + dp[i+1][0];
                    int nb = 0+dp[i+1][1];
                    dp[i][buy] = Math.max(b,nb);
                }
                else
                {
                    int s = prices[i] - fee + dp[i+1][1];
                    int ns = 0+dp[i+1][0];
                    dp[i][buy] = Math.max(s,ns);
                }
            }
        }
        return dp[0][1];
    }
}