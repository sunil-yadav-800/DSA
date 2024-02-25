class Solution {
    public int longestCycle(int[] edges) {
        return solve(edges);
    }
    private int solve(int[] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            adj.add(new ArrayList<>());
            if(edges[i]!=-1)
            {
                adj.get(i).add(edges[i]);
                indegree[edges[i]]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        int cnt=0;
        boolean[] visited = new boolean[edges.length];
        while(!q.isEmpty())
        {
            int node = q.poll();
            visited[node]=true;
            cnt++;
            for(int ad: adj.get(node))
            {
                indegree[ad]--;
                if(indegree[ad]==0)
                {
                    q.add(ad);
                }
            }
        }
        if(cnt==edges.length)
            return -1; //there is no cycle
            
        int ans=0;
        for(int i=0;i<edges.length;i++)
        {
            if(visited[i]==false)
            {
                int len = cycleLength(i,adj,visited);
                ans=Math.max(ans,len);
            }
        }
        return ans;
        
    }
    private int cycleLength(int node, List<List<Integer>> adj, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]=true;
        int count=0;
        while(!q.isEmpty())
        {
            int nn = q.poll();
            count++;
            for(int ad: adj.get(nn))
            {
                if(visited[ad]==false)
                {
                    q.add(ad);
                    visited[ad]=true;
                }
            }
        }
        return count;
    }
}