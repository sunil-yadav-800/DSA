class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans=0;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(matrix[i][j]=='1')
                {
                    if(i==0 || j==0)
                    {
                        dp[i][j]=1;
                    }
                    else
                    {
                        dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                    }
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}