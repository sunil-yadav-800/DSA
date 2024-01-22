class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));
        for(int i=0;i<points.length;i++)
        {
            pq.add(points[i]);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        int index=0;
        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            ans[index][0] = arr[0];
            ans[index][1] = arr[1];
            index++;
        }
        return ans;
    }
}