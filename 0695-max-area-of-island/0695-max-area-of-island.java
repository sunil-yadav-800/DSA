public class Pair{
    int row;
    int col;
    public Pair(int row, int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==0)
                {
                    int area = bfs(i,j,grid,visited);
                    ans=Math.max(ans,area);
                }
            }
        }
        return ans;
    }
    private int bfs(int row, int col, int[][] grid, int[][] visited)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        visited[row][col]=1;
        
        int[] delRow = {-1,0,0,1};
        int[] delCol = {0,-1,1,0};
        int area=0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int currRow = p.row;
            int currCol = p.col;
            area++;
            for(int i=0;i<4;i++)
            {
                int nRow = currRow+delRow[i];
                int nCol = currCol+delCol[i];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]==1 && visited[nRow][nCol]==0)
                {
                    visited[nRow][nCol]=1;
                    q.add(new Pair(nRow,nCol));
                }
            }
        }
        return area;
    }
}