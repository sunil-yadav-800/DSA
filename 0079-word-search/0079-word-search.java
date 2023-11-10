class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                boolean result = Solve(board,i,j,word,0,new boolean[board.length][board[0].length]);
                if(result)
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean Solve(char[][] board, int row, int col, String word, int index, boolean[][] visited)
    {
        if(index == word.length())
        {
            return true;
        }
        //boudary check
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || visited[row][col])
        {
            return false;
        }
        //right
        boolean right=false;
        if(board[row][col] == word.charAt(index))
        {
            visited[row][col]=true;
            right  = Solve(board,row,col+1,word,index+1,visited);
            visited[row][col]=false;
        }
        //down
        boolean down=false;
        if(board[row][col] == word.charAt(index))
        {
           visited[row][col]=true;
           down = Solve(board,row+1,col,word,index+1,visited);
           visited[row][col]=false;
        }
        //left
        boolean left = false;
        if(board[row][col] == word.charAt(index))
        {
           visited[row][col]=true;
           left = Solve(board,row,col-1,word,index+1,visited);
           visited[row][col]=false;
        }
        //up
        boolean up=false;
        if(board[row][col] == word.charAt(index))
        {
           visited[row][col]=true;
           up = Solve(board,row-1,col,word,index+1,visited);
           visited[row][col]=false;
        }
        return (right || down || left || up);
    }
}