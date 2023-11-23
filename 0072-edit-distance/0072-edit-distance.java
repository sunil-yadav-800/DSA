class Solution {
    public int minDistance(String word1, String word2) {
        /*
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
        {
            for(int j=0;j<=word2.length();j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(word1,word2,word1.length()-1,word2.length()-1,dp);
        */
        return solve2(word1,word2);
    }
    private int solve(String word1, String word2, int i, int j, int[][] dp)
    {
        //base case
        if(i<0)
        {
            return j+1; //insert
        }
        if(j<0)
        {
            return i+1; //delete
        }
        if(dp[i][j] !=-1)
        {
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j))
        {
            return dp[i][j] = 0+solve(word1,word2,i-1,j-1,dp);
        }
        else
        {
        int insert = 1+solve(word1,word2,i,j-1,dp);
        int delete = 1+solve(word1,word2,i-1,j,dp);
        int replace = 1+solve(word1,word2,i-1,j-1,dp);
        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
        }
    }
    private int solve2(String word1, String word2)
    {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //base case
        for(int i=0;i<=word2.length();i++)
        {
            dp[0][i]=i;
        }
        for(int i=0;i<=word1.length();i++)
        {
            dp[i][0]=i;
        }
        for(int i=1;i<=word1.length();i++)
        {
            for(int j=1;j<=word2.length();j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    int insert = 1+dp[i][j-1];
                    int delete = 1+dp[i-1][j];
                    int replace = 1+dp[i-1][j-1];
                    dp[i][j] = Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}