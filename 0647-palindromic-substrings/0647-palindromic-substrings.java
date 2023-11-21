class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            //odd
            ans+=helper(s,i,i);
            //even
            ans+=helper(s,i,i+1);
        }
        return ans;
    }
    private int helper(String s, int left, int right)
    {
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right))
        {
                count++;
                left--;
                right++;
        }
        return count;
    }
}