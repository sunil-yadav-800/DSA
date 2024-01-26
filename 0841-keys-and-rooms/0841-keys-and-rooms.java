class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(0,rooms,visited);
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
                return false;
        }
        return true;
    }
    public void dfs(int node, List<List<Integer>> rooms, boolean[] visited)
    {
        visited[node]=true;
        for(int adj:rooms.get(node))
        {
            if(!visited[adj])
            {
                dfs(adj,rooms,visited);
            }
        }
    }
}