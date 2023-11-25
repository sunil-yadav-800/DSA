class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(s,t,0,0,dp);
    }
    private int solve(String s, String t, int i, int j, int[][] dp)
    {
        if(j == t.length())
        {
            return 1;
        }
        if(i == s.length())
        {
            return 0;
        }
        if(dp[i][j] !=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j))
        {
            int take = solve(s,t,i+1,j+1,dp);
            int notTake = solve(s,t,i+1,j,dp);
            return dp[i][j] =  take+notTake;
        }
        else
        {
            return dp[i][j] = solve(s,t,i+1,j,dp);
        }
    }
}