class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(board,0,0);
    }
    private boolean sudoku(char[][] board, int row, int col)
    {
        if(col == board[0].length)
        {
            row=row+1;
            col=0;
        }
        if(row == board.length)
        {
            //print board
            /*
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[0].length;j++)
                {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            */
            return true;
        }
        
        if(board[row][col] == '.')
        {
            for(char ch='1';ch<='9';ch++)
            {
                if(isSafe(board,row,col,ch))
                {
                    board[row][col]=ch;
                    if(sudoku(board,row,col+1) == true)
                    {
                        return true;
                    }
                    board[row][col]='.';
                }
            }
        }
        else
        {
            if(sudoku(board,row,col+1) == true)
            {
                return true;
            }
        }
        return false;
    }
    private boolean isSafe(char[][] board, int row, int col, char ch)
    {
        //check for column
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i] == ch)
            {
                return false;
            }
        }
        //check for rows
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col] == ch)
            {
                return false;
            }
        }
        int size = (int)Math.sqrt(board.length);
        int r = row/size*size;
        int c = col/size*size;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i+r][j+c] == ch)
                {
                    return false;
                }
            }
        }
        return true;
    }
}