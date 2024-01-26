class Solution {
    public int snakesAndLadders(int[][] board) {
        reArrangeBoard(board);
        return bfs(board);
    }
    private void reArrangeBoard(int[][] board)
    {
        // reverse rows
        int start=0;
        int end=board.length-1;
        while(start<end)
        {
            for(int i=0;i<board[0].length;i++)
            {
                //swap
                int temp=board[start][i];
                board[start][i]=board[end][i];
                board[end][i]=temp;
            }
            start++;
            end--;
        }
        
        //reverse odd columns
        for(int i=0;i<board.length;i++)
        {
            if(i%2!=0)
            {
                 start=0;
                 end=board[0].length-1;
                while(start<end)
                {
                    //swap
                    int temp=board[i][start];
                    board[i][start]=board[i][end];
                    board[i][end]=temp;
                    
                    start++;
                    end--;
                }
            }
        }
    }
    private int bfs(int[][] board)
    {
        int n = board.length;
        boolean visited[] = new boolean[n*n+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0}); //num,move
        visited[1]=true;
        
        while(!q.isEmpty())
        {
            int[] arr = q.poll();
            int curr = arr[0];
            int move = arr[1];
            
            if(curr == n*n)
                return move;
            
            for(int i=curr+1;i<=Math.min(curr+6,n*n);i++)
            {
                int nextSquare = i;
                int[] cell = getRowColOfSquare(nextSquare,n);
                //ladder or snake
                if(board[cell[0]][cell[1]] !=-1)
                {
                    nextSquare = board[cell[0]][cell[1]];
                }
                if(!visited[nextSquare])
                {
                    q.add(new int[]{nextSquare,move+1});
                    visited[nextSquare]=true;
                }
            }
        }
        
        return -1;
    }
    private int[] getRowColOfSquare(int square, int n)
    {
        int row = (square-1)/n;
        int col = (square-1)%n;
        
        return new int[]{row,col};
    }
}