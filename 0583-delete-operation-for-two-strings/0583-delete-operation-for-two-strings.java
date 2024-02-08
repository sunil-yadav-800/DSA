class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    private int solve(String word1, String word2, int idx1, int idx2, int[][] dp)
    {
        if(idx1<0)
        {
            return idx2+1;
        }
        if(idx2<0)
        {
            return idx1+1;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        if(word1.charAt(idx1) == word2.charAt(idx2))
        {
            return dp[idx1][idx2] = 0+solve(word1,word2,idx1-1,idx2-1,dp);
        }
        else
        {
            int option1 = 1+solve(word1,word2,idx1-1,idx2,dp);
            int option2 = 1+solve(word1,word2,idx1,idx2-1,dp);
            return dp[idx1][idx2] = Math.min(option1,option2);
        }
    }
}