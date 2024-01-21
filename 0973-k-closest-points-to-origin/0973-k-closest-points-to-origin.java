class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0]*a[0]+a[1]*a[1],b[0]*b[0]+b[1]*b[1]));
        for(int i=0;i<points.length;i++)
        {
            pq.add(points[i]);
        }
        
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++)
        {
            int[] arr = pq.poll();
            ans[i][0] = arr[0];
            ans[i][1] = arr[1];
        }
        return ans;
    }
}