class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        //List<String> list = new ArrayList<>();
        char[][] board = new char[n][n]; 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        Solve(board,0,0,0,n,ans);
        return ans;
    }
    private void Solve(char[][] board, int row, int col, int curr, int n, List<List<String>> ans)
    {
        if(curr == n)
        {
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }
        if(col == n)
        {
            row=row+1;
            col=0;
        }
        if(row == n)
        {
            return;
        }
        if(isSafe(board,row,col))
        {
            board[row][col]='Q';
            Solve(board,row,col+1,curr+1,n,ans);
            board[row][col]='.';
        }
        
       Solve(board,row,col+1,curr,n,ans);
        
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