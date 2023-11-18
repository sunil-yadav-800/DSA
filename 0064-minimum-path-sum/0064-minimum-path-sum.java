class Solution {
    public int minPathSum(int[][] grid) {
        /*
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(grid,m-1,n-1,dp);
        */
        return solve2(grid);
    }
    private int solve(int[][] grid, int row, int col, int[][] dp)
    {
        if(row == 0 && col== 0)
        {
            return grid[0][0];
        }
        if(dp[row][col]!=-1)
            return dp[row][col];
        
        int up = Integer.MAX_VALUE;
        if(row-1>=0)
        {
            up=grid[row][col]+solve(grid,row-1,col,dp);
        }
        int left = Integer.MAX_VALUE;
        if(col-1>=0)
        {
            left=grid[row][col]+solve(grid,row,col-1,dp);
        }
        return dp[row][col] = Math.min(up,left);
    }
    private int solve2(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //base case
        dp[0][0]=grid[0][0];
        
        for(int row=0;row<m;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(row == 0 && col == 0)
                {
                    continue;
                }
                int up = Integer.MAX_VALUE;
                if(row-1>=0)
                {
                    up=grid[row][col]+dp[row-1][col];
                }
                int left = Integer.MAX_VALUE;
                if(col-1>=0)
                {
                    left=grid[row][col]+dp[row][col-1];
                }
               dp[row][col] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }
}