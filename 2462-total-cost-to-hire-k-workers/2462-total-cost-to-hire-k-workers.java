class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        return cost(costs,k,candidates);
    }
    private long cost(int[] costs, int k, int candidates)
    {
        long totalCost=0;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for(int i=0;i<candidates;i++)
        {
            left.add(costs[i]);
        }
        int cnt=0;
        for(int i=costs.length-1;i>=candidates && cnt<candidates;i--)
        {
            cnt++;
            right.add(costs[i]);
        }
        
        int nextLeft=candidates;
        int nextRight=costs.length-candidates-1;
        
        for(int i=0;i<k;i++)
        {
            if(right.isEmpty() || (!left.isEmpty() && left.peek()<=right.peek()))
            {
                totalCost+=left.poll();
                if(nextLeft<=nextRight)
                {
                    left.add(costs[nextLeft]);
                    nextLeft++;
                }
            }
            else
            {
                totalCost+=right.poll();
                if(nextLeft<=nextRight)
                {
                    right.add(costs[nextRight]);
                    nextRight--;
                }
            }
        }
        return totalCost;
    }
}