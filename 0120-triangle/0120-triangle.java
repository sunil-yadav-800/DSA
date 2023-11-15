class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
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
    }
    private int Solve1(List<List<Integer>> triangle, int row, int col, int[][] dp)
    {
        //base 
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
}