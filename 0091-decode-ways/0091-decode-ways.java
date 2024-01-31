class Solution {
    public int numDecodings(String s) {
        /*
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return Solve1(s,0,dp);
        */
        
        //return recur(s,0);
        
        return Tabulation(s);
    }
    private int Solve1(String s, int idx, int[] dp)
    {
        //base case
        if(idx == s.length())
        {
            return 1;
        }
        if(dp[idx] !=-1)
            return dp[idx];
        int ans=0;
        for(int i=idx+1;i<=s.length();i++)
        {
            String str = s.substring(idx,i);
            if(str.length()>2)
                continue;
            
            int value = Integer.valueOf(str);
            
            if(str.charAt(0)!='0' && value<=26)
            {
               ans+=Solve1(s,i,dp);
            }
        }
       return dp[idx] = ans;
    }
    private int recur(String s, int idx)
    {
        //base case
        if(idx == s.length())
        {
            return 1;
        }
        
        int ans=0;
        for(int i=idx+1;i<=s.length();i++)
        {
            String str = s.substring(idx,i);
            if(str.length()>2)
                continue;
            
            int value = Integer.valueOf(str);
            
            if(str.charAt(0)!='0' && value<=26)
            {
               ans+=recur(s,i);
            }
        }
       return ans;
    }
    private  int Tabulation(String s)
    {
        int[] dp = new int[s.length()+1];
        //base case 
        dp[s.length()]=1;

        for(int idx = s.length()-1;idx>=0;idx--)
        {
            int count=0;
            for(int i=idx+1;i<=s.length();i++)
            {
                String str = s.substring(idx,i);
                if(str.length()>2)
                {
                    continue;
                }
                int value = Integer.valueOf(str);
                if(str.charAt(0)!='0' && value<=26)
                {
                    count+=dp[i];
                }
            }
             dp[idx] = count;
        }
        return dp[0];
    }
}