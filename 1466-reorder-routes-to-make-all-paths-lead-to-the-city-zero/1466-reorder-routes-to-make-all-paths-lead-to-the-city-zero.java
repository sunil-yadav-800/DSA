class Solution {
    public int minReorder(int n, int[][] connections) {
        return solve(n,connections);
    }
    private int solve(int n, int[][] connections)
    {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }
        
        boolean[] visited = new boolean[n];
        int[] ans = new int[1];
        DFS(0,adj,visited,ans);
        return ans[0];
    }
    private void DFS(int node, List<List<int[]>> adj, boolean[] visited, int[] ans)
    {
        visited[node]=true;
        for(int[] ad: adj.get(node))
        {
            int nxtNode = ad[0];
            int dir = ad[1];
            if(!visited[nxtNode])
            {
                if(dir == 1)
                    ans[0]++;
                
                DFS(nxtNode,adj,visited,ans);
            }
        }
    }
}