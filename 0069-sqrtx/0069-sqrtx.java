class Solution {
    public int mySqrt(int x) {
        int start=1,end=x/2,res=0;
        if(x==0 || x==1)
            return x;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if((long)mid*mid<=x)
            {
                res=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return res;
        
    }
}