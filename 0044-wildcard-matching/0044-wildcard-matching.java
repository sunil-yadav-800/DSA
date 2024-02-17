class Solution {
    public boolean isMatch(String s, String p) {
        return solve2(s,p);
    }
    public boolean solve2(String s, String p)
    {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++)
        {
            if(p.charAt(i-1)=='*')
            {
                dp[i][0]=dp[i-1][0];
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(p.charAt(i-1)=='*')
                {
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else
                {
                    if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1)=='?')
                    {
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
        
    }
}