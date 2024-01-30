class Solution {
    public int fib(int n) {
        /*
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
       return memo(n,dp);
       */
        return Tabulation(n);
    }
    private int memo(int n, int[] dp)
    {
        if(n==0 || n==1)
            return n;
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        return dp[n] = memo(n-1,dp)+memo(n-2,dp);
    }
    private int Tabulation(int n)
    {
        if(n<=1)
            return n;
        
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}