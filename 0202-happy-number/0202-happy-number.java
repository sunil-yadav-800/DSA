class Solution {
    public boolean isHappy(int n) {
        //return Approach1(n);
        return Approach2(n);
    }
    public boolean Approach1(int n)
    {
        if(n==1 || n==7)
            return true;
        if(n<10)
            return false;
        int sum=0;
        while(n>0)
        {
            sum+=(n%10)*(n%10);
            n/=10;
        }
     return isHappy(sum);
    }
    private boolean Approach2(int n)
    {
        if(n==1)
            return true;
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n))
        {
            set.add(n);
            n = digitsSum(n);
            if(n==1)
            {
                return true;
            }
        }
        return false;
    }
    private int digitsSum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int digit = n%10;
            sum=sum+(digit*digit);
            n=n/10;
        }
        return sum;
    }
}