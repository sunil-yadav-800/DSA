class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                int conn = BFS(i,adj,visited);
                list.add(conn);
            }
        }
        
        long ans = 0;
        long sum = 0;

        for (int c : list) {
            sum += c;
            ans += (long) c * (n - sum);
        }

        return ans;
    }
    private int BFS(int node, List<List<Integer>> adj, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]=true;
        int cnt=0;
        while(!q.isEmpty())
        {
            int n = q.poll();
            cnt++;
            for(int ad: adj.get(n))
            {
                if(!visited[ad])
                {
                    q.add(ad);
                    visited[ad]=true;
                }
            }
        }
        return cnt;
    }
}