class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length-1;
        int n = obstacleGrid[0].length-1;
        if(obstacleGrid[m][n]==1)
            return 0;
       /* 
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        return Solve1(obstacleGrid,m,n,dp);
        */
        return Solve2(obstacleGrid);
    }
    private int Solve1(int[][] grid, int row, int col, int[][] dp)
    {
        //base case
        if(row==0 && col==0)
            return 1;
        if(dp[row][col]!=-1)
            return dp[row][col];
        
        int up = 0;
        if(row-1>=0 && grid[row-1][col]!=1)
        {
            up = Solve1(grid,row-1,col,dp);
        }
        int left = 0;
        if(col-1>=0 && grid[row][col-1]!=1)
        {
            left = Solve1(grid,row,col-1,dp);
        }
        return dp[row][col] = up+left;
    }
    private int Solve2(int[][] grid)
    {
        int[][] dp = new int[grid.length][grid[0].length];
        //base case
        dp[0][0]=1;
        for(int row=0;row<grid.length;row++)
        {
            for(int col=0;col<grid[0].length;col++)
            {
                if(row==0 && col==0)
                    continue;
                
                int up = 0;
                if(row-1>=0 && grid[row-1][col]!=1)
                {
                    up = dp[row-1][col];
                }
                int left = 0;
                if(col-1>=0 && grid[row][col-1]!=1)
                {
                    left = dp[row][col-1];
                }
                
               dp[row][col] = up+left;
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}