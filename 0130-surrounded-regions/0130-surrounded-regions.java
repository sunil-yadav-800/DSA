class Cell{
    int row;
    int col;
    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O' && visited[0][i]==0)
            {
                bfs(0,i,m,n,visited,board);
            }
            if(board[m-1][i]=='O' && visited[m-1][i]==0)
            {
                bfs(m-1,i,m,n,visited,board);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0] == 'O' && visited[i][0] == 0)
            {
                bfs(i,0,m,n,visited,board);
            }
            if(board[i][n-1] == 'O' && visited[i][n-1] == 0)
            {
                bfs(i,n-1,m,n,visited,board);
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0 && board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
    public void bfs(int row, int col, int m, int n, int[][]visited, char[][]board)
    {
        Queue<Cell> q = new LinkedList<>();
        int[] delRow = new int[]{-1,0,0,1};
        int[] delCol = new int[]{0,-1,1,0};
        q.add(new Cell(row,col));
        visited[row][col]=1;
        while(!q.isEmpty())
        {
            Cell c = q.poll();
            int currRow = c.row;
            int currCol = c.col;
            
            for(int i=0;i<4;i++)
            {
                int nRow = currRow+delRow[i];
                int nCol = currCol+delCol[i];
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && visited[nRow][nCol]==0 && board[nRow][nCol]=='O')
                {
                    visited[nRow][nCol]=1;
                    q.add(new Cell(nRow,nCol));
                }
            }
        }
    }
}