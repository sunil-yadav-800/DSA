class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for(int i=0;i<arr.length;i++)
        {
            int rem = arr[i]%k;
            if(rem<0)
            {
                rem=rem+k;
            }
            mod[rem]++;
        }
        if(mod[0]%2!=0)
        {
           return false;
        }
        int start=1,end=mod.length-1;
        while(start<end)
        {
            if(mod[start]!=mod[end])
                return false;
                start++;
            end--;
        }
        return true;
    }
}