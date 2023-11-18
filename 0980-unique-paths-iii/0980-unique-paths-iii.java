class Solution {
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    return helper(grid,i,j);
                }
            }
        }
        return -1;
    }
    private int helper(int[][] grid, int row, int col)
    {
        //base case
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==-1)
        {
            return 0;
        }
        if(grid[row][col] == 2)
        {
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    if(grid[i][j]==0)
                        return 0;
                }
            }
            return 1;
        }
        
        grid[row][col]=-1;
        int up = helper(grid,row-1,col);
        int down = helper(grid,row+1,col);
        int left = helper(grid,row,col-1);
        int right = helper(grid,row,col+1);
        grid[row][col]=0;
        return (up+down+left+right);
    }
}