class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Memo(n,dp);
    }
    private int Memo(int n,int[] dp)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = Memo(n-3,dp)+Memo(n-2,dp)+Memo(n-1,dp);
    }
}