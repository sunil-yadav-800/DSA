class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        return BFS(maze,entrance);
    }
    public int BFS(char[][] maze, int[] entrance)
    {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int minSteps=Integer.MAX_VALUE;
        
        q.add(new int[]{entrance[0],entrance[1],0});
        visited[entrance[0]][entrance[1]]=true;
        while(!q.isEmpty())
        {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int step = cell[2];
            //store the ans if possible
            if(row == 0 || row == maze.length-1 || col == 0 || col == maze[0].length-1)
            {
                if(row!=entrance[0] || col!=entrance[1])
                {
                    minSteps = Math.min(minSteps,step);
                }
            }
            
            for(int i=0;i<4;i++)
            {
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];
                if(nRow>=0 && nRow<maze.length && nCol>=0 && nCol<maze[0].length && maze[nRow][nCol]=='.' && !visited[nRow][nCol])
                {
                    q.add(new int[]{nRow,nCol,step+1});
                    visited[nRow][nCol]=true;
                }
            }
        }
        
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}