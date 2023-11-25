class Solution {
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][256+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<=256;j++)
            {
                dp[i][j]=-1;
            }
        }
        return (int)solve(n,'#',dp);
    }
    private long solve(int n, char prev, long[][] dp)
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[n][prev] !=-1)
        {
            return dp[n][prev]%1000000007;
        }
        long as = 0;
        if(prev == '#' || prev == 'e' || prev == 'i' || prev == 'u')
        {
            as = solve(n-1,'a',dp)%1000000007;
        }
        long es = 0;
        if(prev == '#' || prev == 'a' || prev == 'i')
        {
            es = solve(n-1,'e',dp)%1000000007;
        }
        long is = 0;
        if(prev == '#' || prev == 'e' || prev == 'o')
        {
            is = solve(n-1,'i',dp)%1000000007;
        }
        long os = 0;
        if(prev == '#' || prev == 'i')
        {
            os = solve(n-1,'o',dp)%1000000007;
        }
        long us = 0;
        if(prev == '#' || prev == 'i' || prev == 'o')
        {
            us = solve(n-1,'u',dp)%1000000007;
        }
        return dp[n][prev] = (as+es+is+os+us)%1000000007;
    }
}
/*
a -> e
e -> a, i
i -> a, e, o, u
o -> i, u
u -> a
*/