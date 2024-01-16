class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                boolean flag = bfs(i,graph,color,adj);
                if(flag==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node, int[][] graph, int[] color, List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        
        while(!q.isEmpty())
        {
            int nd = q.poll();
            int clr = color[nd];
            
            for(int ad : adj.get(nd))
            {
                if(color[ad]==-1)
                {
                    color[ad]=1-clr;
                    q.add(ad);
                }
                else if(color[ad] == clr)
                {
                    return false;
                }
            }
        }
        return true;
    }
}