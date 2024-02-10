class Solution {
    public int numTilings(int n) {
        /*
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
        */
        return solve2(n);
    }
    public int solve(int n, int[] dp)
    {
        if(n<=2)
            return n;
        if(n==3)
            return 5;
        if(dp[n]!=-1)
            return dp[n]%1000000007;
        return dp[n] = ((solve(n-1,dp)*2)%1000000007 + solve(n-3,dp)%1000000007)%1000000007;
    }
    private int solve2(int n)
    {
        if(n<=2)
            return n;
        if(n==3)
            return 5;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        for(int i=4;i<=n;i++)
        {
            dp[i]=((dp[i-1]*2)%1000000007 + dp[i-3]%1000000007)%1000000007;
        }
        return dp[n];
    }
}