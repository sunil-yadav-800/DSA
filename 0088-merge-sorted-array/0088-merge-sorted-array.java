class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=0;
        int j=0;
        int k=0;
        int ans[]=new int[m+n];
        while(i<m && j<n)
        {
            if(nums1[i]<nums2[j])
            {
                ans[k]=nums1[i];
                k++;
                i++;
            }
            else
            {
                ans[k]=nums2[j];
                k++;
                j++;
            }
        }
        while(i<m)
        {
            ans[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n)
        {
            ans[k]=nums2[j];
            k++;
            j++;
        }
        
        //store back to nums1
        for( i=0;i<ans.length;i++)
        {
            nums1[i]=ans[i];
        }
    }
}