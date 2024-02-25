class Pair{
    String node;
    double value;
    public Pair(String node, double value)
    {
        this.node=node;
        this.value=value;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return solve(equations,values,queries);
    }
    private double[] solve(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        HashMap<String,List<Pair>> adj = new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            if(!adj.containsKey(first))
            {
                adj.put(first,new ArrayList<Pair>());
            }
            adj.get(first).add(new Pair(second,values[i]));
            
            if(!adj.containsKey(second))
            {
                adj.put(second,new ArrayList<Pair>());
            }
            adj.get(second).add(new Pair(first,1/values[i]));
        }
        
        double[] ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++)
        {
            if(!adj.containsKey(queries.get(i).get(0)) || !adj.containsKey(queries.get(i).get(1)))
            {
                ans[i]=(double)-1;
            }
            else
            {
                ans[i]=BFS(queries.get(i).get(0),queries.get(i).get(1),adj);
            }
        }
        return ans;
    }
    private double BFS(String src, String des, HashMap<String,List<Pair>> adj)
    {
        HashSet<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,(double)1));
        set.add(src);
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String node = p.node;
            double value = p.value;
            if(node.equals(des))
                return value;
            for(Pair ad: adj.get(node))
            {
                if(!set.contains(ad.node))
                {
                    q.add(new Pair(ad.node,(double)(ad.value*value)));
                    set.add(ad.node);
                }
            }
        }
        return (double)(-1);
    }
}