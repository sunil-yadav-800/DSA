class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    return dfs(i,j,grid,new int[grid.length][grid[0].length]);
            }
        }
        return 0;
    }
    private int dfs(int row, int col, int[][] grid, int[][] visited)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0)
        {
            return 1;
        }
        if(visited[row][col] == 1)
        {
            return 0;
        }
        visited[row][col]=1;
        int left = dfs(row,col-1,grid,visited);
        int up = dfs(row-1,col,grid,visited);
        int right = dfs(row,col+1,grid,visited);
        int down = dfs(row+1,col,grid,visited);
        
        return left+up+right+down;
    }
}