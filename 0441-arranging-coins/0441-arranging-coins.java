class Solution {
    public int arrangeCoins(int n) {
       // return naive(n);
       long l=0,h=n;
        int ans=1;
        while(l<=h)
        {
            long mid = (long)(l+(h-l)/2);
            long coins = (long)(mid*(mid+1))/2;
            if(coins == n)
            {
                return (int)mid;
            }
            if(coins>n)
            {
                h=mid-1;
            }
            else
            {
                ans=(int)mid;
                l=mid+1;
            }
            
        }
        return ans;
    }
    //brute force
    public int naive(int n)
    {
        if(n==1)
            return 1;
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            if(sum+i>n)
                return i-1;
            sum+=i;
        }
        return -1;
    }
}