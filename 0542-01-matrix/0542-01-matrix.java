class Solution {
    public int[][] updateMatrix(int[][] mat) {
        return solve(mat);
    }
    private int[][] solve(int[][] mat)
    {
        int[][] ans = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty())
        {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int dis = cell[2];
            ans[row][col]=dis;
            
            for(int i=0;i<4;i++)
            {
                int nRow = delRow[i]+row;
                int nCol = delCol[i]+col;
                if(nRow>=0 && nRow<mat.length && nCol>=0 && nCol<mat[0].length && visited[nRow][nCol]==false)
                {
                    q.add(new int[]{nRow,nCol,dis+1});
                    visited[nRow][nCol]=true;
                }
            }
        }
        return ans;
    }
}