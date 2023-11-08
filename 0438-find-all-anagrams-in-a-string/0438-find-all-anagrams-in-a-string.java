class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        for(int i=0;i<p.length();i++)
        {
            pFreq[p.charAt(i)-'a']++;
            if(i<s.length())
            sFreq[s.charAt(i)-'a']++;
        }
        int start=0,end=p.length();
        while(end<s.length())
        {
            if(isAnagram(sFreq,pFreq))
            {
                ans.add(start);
            }
            sFreq[s.charAt(start)-'a']--;
            sFreq[s.charAt(end)-'a']++;
            start++;
            end++;
        }
        if(isAnagram(sFreq,pFreq))
        {
            ans.add(start);
        }
        return ans;
    }
    public boolean isAnagram(int[] sFreq, int[] pFreq)
    {
        for(int i=0;i<sFreq.length;i++)
        {
            if(sFreq[i]!=pFreq[i])
                return false;
        }
        return true;
    }
}