class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1)
            return strs[0];
        String ans = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            String matchedSubstring = findMatch(ans,strs[i]);
            if(matchedSubstring == "")
                return "";
            ans = matchedSubstring;
        }
        return ans;
    }
    public String findMatch(String s1, String s2)
    {
        String ans = "";
        int i=0,j=0;
        while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j))
        {
            ans+=s1.charAt(i);
            i++;
            j++;
        }
        return ans;
    }
}