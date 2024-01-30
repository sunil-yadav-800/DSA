class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
         Arrays.fill(dp,-1);
         int one = Memoization(cost,0,dp);
         Arrays.fill(dp,-1);
         int two = Memoization(cost,1,dp);
        return Math.min(one,two);
    }
    private int Memoization(int[] cost, int idx, int[] dp)
    {
        if(idx>=cost.length)
            return 0;
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int step1 = cost[idx]+Memoization(cost,idx+1,dp);
        int step2 = 0;
        if(idx<=cost.length-1)
        {
            step2 = cost[idx]+Memoization(cost,idx+2,dp);
        }
        return dp[idx] =  Math.min(step1,step2);
    }
}