class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        return BFS(grid);
    }
    private int BFS(int[][] grid)
    {
        if(grid[0][0]==1)
            return -1;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] delRow = {-1,-1,0,1,1,1,0,-1};
        int[] delCol = {0,1,1,1,0,-1,-1,-1};
        q.add(new int[]{0,0,1}); // row,col,steps
        visited[0][0]=true;
        while(!q.isEmpty())
        {
            int[] arr = q.poll();
            int currRow=arr[0];
            int currCol=arr[1];
            int step=arr[2];
            if(currRow == grid.length-1 && currCol == grid.length-1)
            {
                return step;
            }
            for(int i=0;i<8;i++)
            {
                int nextRow=currRow+delRow[i];
                int nextCol=currCol+delCol[i];
                if(nextRow>=0 && nextRow<grid.length && nextCol>=0 && nextCol<grid[0].length && grid[nextRow][nextCol]==0 && visited[nextRow][nextCol]==false)
                {
                    visited[nextRow][nextCol]=true;
                    q.add(new int[]{nextRow,nextCol,step+1});
                }
            }
        }
        return -1;
        
    }
}