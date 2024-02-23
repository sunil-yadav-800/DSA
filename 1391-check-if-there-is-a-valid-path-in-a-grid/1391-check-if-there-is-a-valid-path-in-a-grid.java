class Solution {
    public boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        DFS(0,0,grid,visited);
        
        return visited[grid.length-1][grid[0].length-1];
        
    }
    private void DFS(int row, int col, int[][] grid, boolean[][] visited)
    {
        visited[row][col]=true;
        if(grid[row][col]==1)
        {
            if(isValidPath(row,col-1,grid,visited) && (grid[row][col-1]==1 || grid[row][col-1]==4 || grid[row][col-1]==6))
            {
                DFS(row,col-1,grid,visited);
            }
            if(isValidPath(row,col+1,grid,visited) && (grid[row][col+1]==1 || grid[row][col+1]==3 || grid[row][col+1]==5))
            {
                DFS(row,col+1,grid,visited);
            }
        }
        if(grid[row][col]==2)
        {
            if(isValidPath(row-1,col,grid,visited) && (grid[row-1][col]==2 || grid[row-1][col]==3 || grid[row-1][col]==4))
            {
                DFS(row-1,col,grid,visited);
            }
            if(isValidPath(row+1,col,grid,visited) && (grid[row+1][col]==2 || grid[row+1][col]==5 || grid[row+1][col]==6))
            {
                DFS(row+1,col,grid,visited);
            }
        }
        if(grid[row][col]==3)
        {
            if(isValidPath(row,col-1,grid,visited) && (grid[row][col-1]==1 || grid[row][col-1]==4 || grid[row][col-1]==6))
            {
                DFS(row,col-1,grid,visited);
            }
            if(isValidPath(row+1,col,grid,visited) && (grid[row+1][col]==2 || grid[row+1][col]==5 || grid[row+1][col]==6))
            {
                DFS(row+1,col,grid,visited);
            }
        }
        if(grid[row][col]==4)
        {
            if(isValidPath(row,col+1,grid,visited) && (grid[row][col+1]==1 || grid[row][col+1]==3 || grid[row][col+1]==5))
            {
                DFS(row,col+1,grid,visited);
            }
            if(isValidPath(row+1,col,grid,visited) && (grid[row+1][col]==2 || grid[row+1][col]==5 || grid[row+1][col]==6))
            {
                DFS(row+1,col,grid,visited);
            }
        }
        if(grid[row][col]==5)
        {
            if(isValidPath(row,col-1,grid,visited) && (grid[row][col-1]==1 || grid[row][col-1]==4 || grid[row][col-1]==6))
            {
                DFS(row,col-1,grid,visited);
            }
            if(isValidPath(row-1,col,grid,visited) && (grid[row-1][col]==2 || grid[row-1][col]==3 || grid[row-1][col]==4))
            {
                DFS(row-1,col,grid,visited);
            }
        }
        if(grid[row][col]==6)
        {
            if(isValidPath(row,col+1,grid,visited) && (grid[row][col+1]==1 || grid[row][col+1]==3 || grid[row][col+1]==5))
            {
                DFS(row,col+1,grid,visited);
            }
            if(isValidPath(row-1,col,grid,visited) && (grid[row-1][col]==2 || grid[row-1][col]==3 || grid[row-1][col]==4))
            {
                DFS(row-1,col,grid,visited);
            }
        }
    }
    private boolean isValidPath(int row, int col, int[][] grid, boolean[][] visited)
    {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col])
        {
            return false;
        }
        return true;
    }
}