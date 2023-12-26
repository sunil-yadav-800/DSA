class Solution {
    public boolean closeStrings(String word1, String word2) {
        return solve(word1,word2);
    }
    public boolean solve(String word1, String word2)
    {
        if(word1.length()!=word2.length())
            return false;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(int i=0;i<word1.length();i++)
        {
            arr1[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();i++)
        {
            arr2[word2.charAt(i)-'a']++;
        }
        
        //each character of a string should be persent in another string.
        for(int i=0;i<26;i++)
        {
            if((arr1[i]!=0 && arr2[i]==0) || (arr1[i]==0 && arr2[i]!=0))
                return false;
        }
        
        //requency of a character in one string should match with the frequency of any character in another string. 
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<26;i++)
        {
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }
}