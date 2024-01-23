class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        return Solve(k,w,profits,capital);
    }
    private int Solve(int k, int w, int[] profits, int[] capital)
    {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(k>0)
        {
            while(i<n && w>=arr[i][1])
            {
                pq.add(arr[i][0]);
                i++;
            }
            if(!pq.isEmpty())
            {
                w+=pq.poll();
            }
            k--;
        }
        return w;
    }
}