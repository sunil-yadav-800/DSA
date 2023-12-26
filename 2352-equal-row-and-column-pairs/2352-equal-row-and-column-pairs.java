class Solution {
    public int equalPairs(int[][] grid) {
        
        return solve(grid);
    }
    public int solve(int[][] grid)
    {
        int ans=0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<grid.length;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid[i].length;j++)
            {
                sb.append(grid[i][j]).append(',');
            }
            String str = sb.toString();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        for(int i=0;i<grid.length;i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid[i].length;j++)
            {
                sb.append(grid[j][i]).append(',');
            }
            String str = sb.toString();
            if(map.containsKey(str))
                ans+=map.get(str);
            
        }
        
        return ans;
    }
}