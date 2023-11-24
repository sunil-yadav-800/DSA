class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length()+s2.length())
        {
            return false;
        }
        /*
        boolean[][][] dp = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return solve(s1,s2,s3,0,0,0,dp);
        */
        return solve2(s1,s2,s3);
    }
    private boolean solve(String s1, String s2, String s3, int i, int j, int k, boolean[][][] dp)
    {
        if(k == s3.length())
        {
            return true;
        }
        if(dp[i][j][k])
        {
            return dp[i][j][k];
        }
        if(i<s1.length() && j<s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k))
        {
            boolean takeFromS1 = solve(s1,s2,s3,i+1,j,k+1,dp);
            boolean takeFromS2 = solve(s1,s2,s3,i,j+1,k+1,dp);
            return dp[i][j][k] = (takeFromS1 || takeFromS2);
        }
        else if(i<s1.length() && s1.charAt(i) == s3.charAt(k))
        {
            return dp[i][j][k] = solve(s1,s2,s3,i+1,j,k+1,dp);
        }
        else if(j<s2.length() && s2.charAt(j) == s3.charAt(k))
        {
            return dp[i][j][k] = solve(s1,s2,s3,i,j+1,k+1,dp);
        }
        return false; //if not above case
    }
    private boolean solve2(String s1, String s2, String s3)
    {
        boolean[][][] dp = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        //base case
        for(int i=0;i<s1.length()+1;i++)
        {
            for(int j=0;j<s2.length()+1;j++)
            {
                dp[i][j][s3.length()]=true;
            }
        }
        
        for(int i=s1.length();i>=0;i--)
        {
            for(int j=s2.length();j>=0;j--)
            {
                for(int k=s3.length()-1;k>=0;k--)
                {
                      if(i<s1.length() && j<s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k))
                        {
                            boolean takeFromS1 = dp[i+1][j][k+1];
                            boolean takeFromS2 = dp[i][j+1][k+1];
                            dp[i][j][k] = (takeFromS1 || takeFromS2);
                        }
                        else if(i<s1.length() && s1.charAt(i) == s3.charAt(k))
                        {
                            dp[i][j][k] = dp[i+1][j][k+1];
                        }
                        else if(j<s2.length() && s2.charAt(j) == s3.charAt(k))
                        {
                            dp[i][j][k] = dp[i][j+1][k+1];
                        }
                        else
                        {
                            dp[i][j][k] = false;
                        }
                }
            }
        }
        return dp[0][0][0];
    }
}