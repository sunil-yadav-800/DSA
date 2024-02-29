class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length()+s2.length())
        {
            return false;
        }
        
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int i=0;i<s1.length()+1;i++)
        {
            for(int j=0;j<s2.length()+1;j++)
            {
                for(int k=0;k<s3.length()+1;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(s1,s2,s3,0,0,0,dp);
        //return solve2(s1,s2,s3);
    }
    private boolean solve(String s1, String s2, String s3, int i, int j, int k, int[][][] dp)
    {
        if(k == s3.length())
        {
            return true;
        }
        if(dp[i][j][k]!=-1)
        {
            return dp[i][j][k]==1?true:false;
        }
        if(i<s1.length() && j<s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k))
        {
            boolean takeFromS1 = solve(s1,s2,s3,i+1,j,k+1,dp);
            boolean takeFromS2 = solve(s1,s2,s3,i,j+1,k+1,dp);
            dp[i][j][k]=(takeFromS1 || takeFromS2) == true ? 1:0;
            return (takeFromS1 || takeFromS2);
        }
        else if(i<s1.length() && s1.charAt(i) == s3.charAt(k))
        {
            boolean result = solve(s1,s2,s3,i+1,j,k+1,dp);
            dp[i][j][k] = result==true?1:0;
            return result;
        }
        else if(j<s2.length() && s2.charAt(j) == s3.charAt(k))
        {
            boolean result = solve(s1,s2,s3,i,j+1,k+1,dp);
            dp[i][j][k] = result==true?1:0;
            return result;
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