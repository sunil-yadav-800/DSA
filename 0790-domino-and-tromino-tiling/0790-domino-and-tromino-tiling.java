class Solution {
    public int numTilings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
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
}