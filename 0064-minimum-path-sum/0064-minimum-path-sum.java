class Solution {
    public int minPathSum(int[][] grid) {
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
}