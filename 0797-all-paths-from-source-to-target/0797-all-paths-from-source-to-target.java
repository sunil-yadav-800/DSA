class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
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
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        solve(0,graph.length-1,adj,list,ans);
        return ans;
    }
    private void solve(int node, int lastNode, List<List<Integer>> adj, List<Integer> list, List<List<Integer>> ans)
    {
        if(node == lastNode)
        {
            ans.add(new ArrayList<>(list));
        }
        
        for(int ad: adj.get(node))
        {
            list.add(ad);
            solve(ad,lastNode,adj,list,ans);
            list.remove(list.size()-1);
        }
        
    }
}