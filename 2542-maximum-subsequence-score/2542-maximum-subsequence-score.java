class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        return Solve(nums1,nums2,k);
    }
    private long Solve(int[] nums1, int[] nums2, int k)
    {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }
        
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long maxScore=0;
        long currScore=0;
        for(int i=0;i<n;i++)
        {
            currScore+=arr[i][0];
            pq.add(arr[i][0]);
            if(pq.size()>k)
            {
                currScore-=pq.poll();
            }
            if(pq.size() == k)
            {
                maxScore = Math.max(maxScore,currScore*arr[i][1]);
            }
        }
        return maxScore;
    }
}