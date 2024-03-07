class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans="";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0))             {
                    ans = word;
                }
            }
        }
        return ans;
    }
    private boolean isSubsequence(String s, String dict)
    {
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        while(i<s.length() && j<dict.length())
        {
            if(s.charAt(i) == dict.charAt(j))
            {
                sb.append(s.charAt(i));
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        return i==s.length();
    }
}