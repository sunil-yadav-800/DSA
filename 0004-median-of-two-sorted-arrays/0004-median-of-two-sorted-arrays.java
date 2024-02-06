class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int total = n+m;
        int left = (n+m+1)/2;
        
        int l=0,h=n;
        while(l<=h)
        {
            int mid1 = (l+h)/2;
            int mid2 = left-mid1;
            
            int l1 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r2 = Integer.MAX_VALUE;
            
            if(mid1-1>=0)
            {
                l1=nums1[mid1-1];
            }
            if(mid1<n)
            {
                r1=nums1[mid1];
            }
            if(mid2-1>=0)
            {
                l2=nums2[mid2-1];
            }
            if(mid2<m)
            {
                r2=nums2[mid2];
            }
            
            if(l1<=r2 && l2<=r1)
            {
                if(total%2==0)
                {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else
                {
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2)
            {
                h=mid1-1;
            }
            else
            {
                //when l2>r1
                l=mid1+1;
            }
        }
        return 0.0;
    }
}