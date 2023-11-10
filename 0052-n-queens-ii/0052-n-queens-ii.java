class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n]; 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        return Solve(board,0,0,0,n);
        
    }
    private int Solve(char[][] board, int row, int col, int curr, int n)
    {
        if(curr == n)
        {
            return 1;
        }
        if(col == n)
        {
            row=row+1;
            col=0;
        }
        if(row == n)
        {
            return 0;
        }
        int put=0;
        if(isSafe(board,row,col))
        {
            board[row][col]='Q';
            put = Solve(board,row,col+1,curr+1,n);
            board[row][col]='.';
        }
        
       int dput =  Solve(board,row,col+1,curr,n);
        return put+dput;
        
    }
    private boolean isSafe(char[][] board, int row, int col)
    {
        //check for row 
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col] == 'Q')
                return false;
        }
        //check for column
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i] == 'Q')
                return false;
        }
        //left upper diagonal
        int r=row;
        int c=col;
        while(r>=0 && c>=0)
        {
            if(board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        //right upper diagonal
        r=row;
        c=col;
        while(r>=0 && c<board[0].length)
        {
            if(board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }
        return true;
    }
}