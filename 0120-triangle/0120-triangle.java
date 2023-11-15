class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return Solve1(triangle,0,0,dp);
        */
        return Solve2(triangle);
    }
    private int Solve1(List<List<Integer>> triangle, int row, int col, int[][] dp)
    {
        //base case
        if(row == triangle.size()-1)
        {
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=-1)
        {
            return dp[row][col];
        }
            
        int first = triangle.get(row).get(col) + Solve1(triangle, row+1, col, dp);
        int second = triangle.get(row).get(col) + Solve1(triangle, row+1, col+1, dp);
        return dp[row][col] = Math.min(first,second);
    }
    private int Solve2(List<List<Integer>> triangle)
    {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        //base case
        for(int col=0; col<m; col++)
        {
            dp[m-1][col]=triangle.get(m-1).get(col);
        }
        for(int row=m-2;row>=0;row--)
        {
            for(int col=row;col>=0;col--)
            {
                int first = triangle.get(row).get(col) + dp[row+1][col];
                int second = triangle.get(row).get(col) + dp[row+1][col+1];
                dp[row][col]=Math.min(first,second);
            }
        }
        return dp[0][0];
    }
}