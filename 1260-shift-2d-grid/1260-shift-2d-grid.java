class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=k;i++)
        {
            shift(grid);
        }
        for(int i=0;i<grid.length;i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<grid[0].length;j++)
            {
                list.add(grid[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
    public void shift(int[][] grid)
    {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<grid.length-1;i++)
        {
            list.add(grid[i][grid[0].length-1]);
        }
        list.add(0,grid[grid.length-1][grid[0].length-1]);
        for(int col=grid[0].length-2;col>=0;col--)
        {
            for(int row=0;row<grid.length;row++)
            {
                grid[row][col+1]=grid[row][col];
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            grid[i][0]=list.get(i);
        }
    }
}