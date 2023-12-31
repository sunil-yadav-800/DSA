class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(text1,text2,text1.length()-1,text2.length()-1,dp);
        */
        return solve2(text1,text2);
    }
    private int solve(String text1, String text2, int ind1, int ind2, int[][] dp)
    {
        if(ind1<0 || ind2<0)
        {
            return 0;
        }
        if(dp[ind1][ind2]!=-1)
        {
            return dp[ind1][ind2];
        }
        if(text1.charAt(ind1) == text2.charAt(ind2))
        {
            return dp[ind1][ind2] = 1+solve(text1,text2,ind1-1,ind2-1,dp);
        }
        else
        {
            int option1 = solve(text1,text2,ind1-1,ind2,dp);
            int option2 = solve(text1,text2,ind1,ind2-1,dp);
            return dp[ind1][ind2] = Math.max(option1,option2);
        }
    }
    private int solve2(String text1, String text2)
    {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //base case
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++)
        {
            dp[0][i]=0;
        }
        
        for(int ind1=1;ind1<=text1.length();ind1++)
        {
            for(int ind2=1;ind2<=text2.length();ind2++)
            {
                if(text1.charAt(ind1-1) == text2.charAt(ind2-1))
                {
                    dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                }
                else
                {
                    int option1 = dp[ind1-1][ind2];
                    int option2 = dp[ind1][ind2-1];
                    dp[ind1][ind2] = Math.max(option1,option2);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}