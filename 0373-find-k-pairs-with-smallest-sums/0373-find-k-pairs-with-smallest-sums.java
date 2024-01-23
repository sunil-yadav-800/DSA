class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //return Approach1(nums1,nums2,k);
        return Approach2(nums1,nums2,k);
    }
    private List<List<Integer>> Approach1(int[] nums1, int[] nums2, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                int sum=nums1[i]+nums2[j];
                pq.add(new int[]{sum,i,j});
                if(pq.size()>k)
                {
                    pq.poll();
                }
            }
        }
        List<List<Integer>>  ans = new ArrayList<>();
        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[arr[1]]);
            list.add(nums2[arr[2]]);
            ans.add(list);
        }
        return ans;
    }
    private List<List<Integer>> Approach2(int[] nums1, int[] nums2, int k)
    {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashSet<Pair<Integer,Integer>> set = new HashSet<>();
        
        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        set.add(new Pair<Integer,Integer>(0,0));
        
        while(k>0 && !pq.isEmpty())
        {
            int[] arr = pq.poll();
            int i = arr[1];
            int j = arr[2];
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[j]);
            ans.add(list);
            k--;
            
            if(j+1<nums2.length && !set.contains(new Pair<Integer,Integer>(i,j+1)))
            {
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                set.add(new Pair<Integer,Integer>(i,j+1));
            }
            if(i+1<nums1.length && !set.contains(new Pair<Integer,Integer>(i+1,j)))
            {
                pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                set.add(new Pair<Integer,Integer>(i+1,j));
            }
        }
        return ans;
    }
}