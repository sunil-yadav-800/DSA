class Solution {
    public boolean isPowerOfThree(int n) {
        return Solve(n);
    }
    private boolean Solve(int n)
    {
        if(n==1)
            return true;
        if(n%3!=0 || n<=0)
            return false;
        return Solve(n/3);
    }
}