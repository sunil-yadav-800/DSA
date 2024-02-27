class Solution {
    public int swimInWater(int[][] grid) {
        return solve(grid);
    }
    private int solve(int[][] grid)
    {
        //dijikstra's algo
        //min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!pq.isEmpty())
        {
            int[] cell = pq.poll();
            int time=cell[0];
            int row=cell[1];
            int col=cell[2];
            if(row == grid.length-1 && col == grid[0].length-1)
            {
                return time;
            }
            
            for(int i=0;i<4;i++)
            {
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && !visited[nRow][nCol])
                {
                    pq.add(new int[]{Math.max(time,grid[nRow][nCol]),nRow,nCol});
                    visited[nRow][nCol]=true;
                }
            }
        }
        return -1;
    }
}