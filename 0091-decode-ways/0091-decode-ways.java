class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return Solve1(s,dp);
    }
    private int Solve1(String s, int[] dp)
    {
        //base case
        if(s.length() == 0)
        {
            return 1;
        }
        if(dp[s.length()] !=-1)
            return dp[s.length()];
        int ans=0;
        for(int i=1;i<=s.length();i++)
        {
            String str = s.substring(0,i);
            if(str.length()>2)
                continue;
            String next = s.substring(i);
            int value = Integer.valueOf(str);
            
            if(str.charAt(0)!='0' && value<=26)
            {
               ans+=Solve1(next,dp);
            }
        }
       return dp[s.length()] = ans;
    }
}