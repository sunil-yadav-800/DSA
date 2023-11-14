class Solution {
    public int tribonacci(int n) {
        /*
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Memo(n,dp);
        */
        
        //return Table(n);
        
        return spaceOptimize(n);
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
    private int Table(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        int[] dp = new int[n+1];
        //fill base case
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++)
        {
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
    private int spaceOptimize(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        int prev3=0,prev2=1,prev1=1;
        for(int i=3;i<=n;i++)
        {
            int curr = prev3+prev2+prev1;
            prev3=prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}