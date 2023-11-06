class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans=0,vowelsCount=0;
        int start=0,end=0;
        while(end<k)
        {
            char ch = s.charAt(end);
            if(set.contains(ch))
            {
                vowelsCount++;
            }
            end++;
        }
        ans=vowelsCount;
        while(end<s.length())
        {
            if(set.contains(s.charAt(start)))
            {
                vowelsCount--;
            }
            start++;
            if(set.contains(s.charAt(end)))
            {
                vowelsCount++;
            }
            end++;
            ans=Math.max(ans,vowelsCount);
        }
        return ans;
    }
}