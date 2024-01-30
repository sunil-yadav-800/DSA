class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+2][2][3];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(prices,0,1,2,dp);
    }
    private int solve(int[] prices, int i, int buy, int k, int[][][] dp)
    {
        if(k == 0 || i>=prices.length)
        {
            return 0;
        }
        if(dp[i][buy][k] !=-1)
        {
            return dp[i][buy][k];
        }
        if(buy == 1)
        {
            int b = -prices[i] + solve(prices,i+1,0,k,dp);
            int nb = 0+solve(prices,i+1,1,k,dp);
            return dp[i][buy][k] = Math.max(b,nb);
        }
        else
        {
            int s = prices[i] + solve(prices,i+1,1,k-1,dp);
            int ns = 0+solve(prices,i+1,0,k,dp);
            return dp[i][buy][k] = Math.max(s,ns);
        }
    }
}