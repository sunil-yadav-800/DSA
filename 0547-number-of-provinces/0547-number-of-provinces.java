class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int provinces=0;
        boolean visited[] = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(!visited[i])
            {
                provinces++;
                dfs(i,adj,visited);
            }
        }
        return provinces;
    }
    public void dfs(int node, List<List<Integer>> adj, boolean visited[])
    {
        visited[node]=true;
        for(int ad:adj.get(node))
        {
            if(!visited[ad])
            {
                dfs(ad,adj,visited);
            }
        }
    }
}