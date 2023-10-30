class Solution {
    public int integerReplacement(int n) {
        return miniOperation(n);
    }
    public int miniOperation(int n)
    {
        if(n == Integer.MAX_VALUE)
            return 32;
        if(n==1)
            return 0;
        if(n%2==0)
        {
            return 1+miniOperation(n/2);
        }
        else
        {
            return 1+(Math.min(miniOperation(n-1),miniOperation(n+1)));
        }
    }
}