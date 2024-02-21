class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        //put all nodes to the queue having indegree as 0
        for(int i=0;i<graph.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        boolean[] safe = new boolean[graph.length];
        while(!q.isEmpty())
        {
            int node = q.poll();
            safe[node]=true; //indicates that this node will be considered as safe
            for(int ad: adj.get(node))
            {
                indegree[ad]--;
                if(indegree[ad]==0)
                {
                    q.add(ad);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(safe[i]==true)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}