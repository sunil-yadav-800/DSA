class Solution {
    public boolean isMatch(String s, String p) {
        //return solve2(s,p);
        int[][] dp = new int[p.length()][s.length()];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(p,s,p.length()-1,s.length()-1,dp);
    }
    private boolean solve(String p, String s, int i, int j, int[][] dp)
    {
        if(i<0 && j<0)
            return true;
        if(j<0)
        {
            for(int k=0;k<=i;k++)
            {
                if(p.charAt(k)!='*')
                {
                    return false;
                }
            }
            return true;
        }
        if(i<0)
            return false;
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j]==1?true:false;
        }
        boolean result=false;
        if(p.charAt(i)=='*')
        {
            result = solve(p,s,i-1,j,dp) || solve(p,s,i,j-1,dp);
        }
        else if(p.charAt(i) == s.charAt(j) || p.charAt(i)=='?')
        {
            result = solve(p,s,i-1,j-1,dp);
        }
        else
        {
            result = false;
        }
        dp[i][j] = result==true?1:0;
        return result;
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