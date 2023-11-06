class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans=0;
        int start=0,end=0;
        int sum=0;
        while(end<k)
        {
            sum+=arr[end];
            end++;
        }
        if((sum/k)>=threshold)
        {
                ans++;
        }
        while(end<arr.length)
        {
            sum+=arr[end]-arr[start];
            if((sum/k)>=threshold)
            {
                ans++;
            }
            start++;
            end++;
        }
        return ans;
    }
}