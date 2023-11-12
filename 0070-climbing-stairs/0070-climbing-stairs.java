class Solution {
    public int climbStairs(int n) {
        /*
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Memoization(n,dp);
        */
        return Tabulation(n);
    }
    private int Memoization(int n, int[] dp)
    {
        if(n==0)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int step1 = Memoization(n-1,dp);
        
        int step2 = 0;
        if(n>1)
        {
         step2 = Memoization(n-2,dp);
        }
        return dp[n] = step1+step2;
    }
    private int Tabulation(int n)
    {
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            int step1 = dp[i-1];
            int step2 = 0;
            if(i>1)
            {
                step2 = dp[i-2];
            }
            dp[i]=step1+step2;
        }
        return dp[n];
    }
}