class Solution {
    public int shortestPath(int[][] grid, int k) {
        return solve(grid,k);
    }
    private int solve(int[][] grid, int k)
    {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k+1];
        q.add(new int[]{0,0,0,0});
       ////////// visited[0][0]=true;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        while(!q.isEmpty())
        {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int step = cell[2];
            int obstacle = cell[3];
            if(row == grid.length-1 && col == grid[0].length-1)
            {
                return step;
            }
            for(int i=0;i<4;i++)
            {
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length)
                {
                    if(grid[nRow][nCol]==0 && visited[nRow][nCol][obstacle]==false)
                    {
                        q.add(new int[]{nRow,nCol,step+1,obstacle});
                        visited[nRow][nCol][obstacle]=true;
                    }
                    else if(grid[nRow][nCol] == 1 && obstacle+1<=k && visited[nRow][nCol][obstacle+1] == false)
                    {
                        q.add(new int[]{nRow,nCol,step+1,obstacle+1});
                        visited[nRow][nCol][obstacle+1]=true;
                    }
                }
            }
        }
        return -1;
    }
}