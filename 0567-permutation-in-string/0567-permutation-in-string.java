class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        {
            return false;
        }
        int[] first = new int[26];
        int[] second = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            first[s1.charAt(i)-'a']++;
            second[s2.charAt(i)-'a']++;
        }
        for(int i=s1.length();i<s2.length();i++)
        {
            if(isEqual(first,second))
            {
                return true;
            }
            second[s2.charAt(i-s1.length())-'a']--;
            second[s2.charAt(i)-'a']++;
        }
        if(isEqual(first,second))
            return true;
        return false;
    }
    public boolean isEqual(int[] first, int[] second)
    {
        for(int i=0;i<26;i++)
        {
            if(first[i]!=second[i])
                return false;
        }
        return true;
    }
}