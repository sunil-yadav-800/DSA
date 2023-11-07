class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.')
                {
                if(validate(board,i,j)==false)
                    return false;
                }
            }
        }
        return true;
    }
    public boolean validate(char[][] board, int row, int col)
    {
        char ch = board[row][col];
        for(int i=0;i<board[0].length;i++)
        {
            if(i!=col && board[row][i]==ch)
                return false;
        }
        for(int i=0;i<board.length;i++)
        {
            if(i!=row && board[i][col]==ch)
                return false;
        }
        int subBoxSize = (int)Math.sqrt(board.length);
        int r=row/subBoxSize*subBoxSize;
        int c=col/subBoxSize*subBoxSize;
        for(int i=0;i<subBoxSize;i++)
        {
            for(int j=0;j<subBoxSize;j++)
            {
                if((i+r)==row && (j+c)==col)
                    continue;
                if(board[i+r][j+c]==ch)
                    return false;
            }
        }
        return true;
    }
}