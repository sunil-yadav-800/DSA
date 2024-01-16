class Solution {
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }
    public int bfs(int[][] grid)
    {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int totalTime = 0;
        int freshOrange=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                    visited[i][j]=1;
                }
                else if(grid[i][j]==1)
                {
                    freshOrange++;
                }
            }
        }
        
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty())
        {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int time = cell[2];
            
            totalTime = Math.max(totalTime,time);
            
            for(int i=0;i<4;i++)
            {
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && visited[nRow][nCol]==0 && grid[nRow][nCol]==1)
                {
                    q.add(new int[]{nRow,nCol,time+1});
                    visited[nRow][nCol]=1;
                    cnt++;
                }
            }
        }
        
      return cnt!=freshOrange?-1:totalTime;
    }
}