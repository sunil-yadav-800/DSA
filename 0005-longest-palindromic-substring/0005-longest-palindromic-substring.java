class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        int ansLen=0;
        for(int i=0;i<s.length();i++)
        {
            //odd length
            int left=i,right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                if((right-left+1)>ansLen)
                {
                    ans=s.substring(left,right+1);
                    ansLen=right-left+1;
                }
                left--;
                right++;
            }
            //even length
            left=i;
            right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                if((right-left+1)>ansLen)
                {
                    ans=s.substring(left,right+1);
                    ansLen=right-left+1;
                }
                left--;
                right++;
            }
        }
        return ans;
    }
}