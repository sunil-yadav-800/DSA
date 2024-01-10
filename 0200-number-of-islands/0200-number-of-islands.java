class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][] visited = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0 && grid[i][j]=='1')
                {
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,int[][] visited, char[][] grid)
    {
        visited[row][col]=1;
        int[] delRow = new int[] {-1,0,0,1};
        int[] delCol = new int[] {0,-1,1,0};
        for(int i=0;i<4;i++)
        {
           int nRow = delRow[i]+row;
           int nCol = delCol[i]+col;
           if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && visited[nRow][nCol]==0 && grid[nRow][nCol]=='1')
           {
               dfs(nRow,nCol,visited,grid);
           }
        }
    }
}