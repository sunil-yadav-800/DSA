class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
               dp[i][j]=-1;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                int path = solve(matrix,i,j,dp);
                ans=Math.max(ans,path);
            }
        }
        return ans+1;
    }
    private int solve(int[][] matrix, int row, int col, int[][] dp)
    {
        if(dp[row][col] !=-1)
        {
            return dp[row][col];
        }
        //left
        int left = 0;
        if(col-1>=0 && matrix[row][col-1]>matrix[row][col])
        {
            left = 1 + solve(matrix,row,col-1,dp);
        }
        //right
        int right = 0;
        if(col+1<matrix[0].length && matrix[row][col+1]>matrix[row][col])
        {
            right = 1+solve(matrix,row,col+1,dp);
        }
        //up
        int up=0;
        if(row-1>=0 && matrix[row-1][col]>matrix[row][col])
        {
            up=1+solve(matrix,row-1,col,dp);
        }
        //down
        int down=0;
        if(row+1<matrix.length && matrix[row+1][col]>matrix[row][col])
        {
            down = 1+solve(matrix,row+1,col,dp);
        }
        return dp[row][col] = Math.max(left,Math.max(right,Math.max(up,down)));
    }
}