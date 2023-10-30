class Solution {
    public int integerReplacement(int n) {
       return miniOperation(n);
    }
    public int miniOperation(int n)
    {
        if(n == Integer.MAX_VALUE)
            return 32;
        if(n==1)
            return 0;
        if(n%2==0)
        {
            return 1+miniOperation(n/2);
        }
        else
        {
            return 1+(Math.min(miniOperation(n-1),miniOperation(n+1)));
        }
    }
    public int memoization(int n, int[]dp)
    {
        if(n == Integer.MAX_VALUE)
            return 32;
        if(n==1)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        if(n%2==0)
        {
            return dp[n] = 1+memoization(n/2,dp);
        }
        else
        {
            return dp[n] = 1+(Math.min(memoization(n-1,dp),memoization(n+1,dp)));
        }
    }
}