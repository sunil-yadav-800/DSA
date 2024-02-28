class Pair{
    int node;
    int wt;
    public Pair(int _node, int _wt){
        this.node=_node;
        this.wt=_wt;
    }
}
class tuple{
    int stop;
    int wt;
    int node;
    public tuple(int _stop, int _wt, int _node){
        this.stop=_stop;
        this.wt=_wt;
        this.node=_node;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            int u=flights[i][0];
            int v=flights[i][1];
            int wt=flights[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] dist = new int[n];
        Arrays.fill(dist,1000000000);
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,0,src));
        dist[src]=0;
        while(!q.isEmpty())
        {
            int stop=q.peek().stop;
            int wt=q.peek().wt;
            int node=q.peek().node;
            q.remove();
            if(stop>k)
            {
                continue;
            }
            for(Pair it: adj.get(node))
            {
                int adjNode=it.node;
                int adjWt=it.wt;
                if(wt+adjWt<dist[adjNode])
                {
                    dist[adjNode]=wt+adjWt;
                    q.add(new tuple(stop+1,dist[adjNode],adjNode));
                }
            }
        }
        if(dist[dst]==1000000000)
        return -1;
        return dist[dst];
    }
}