class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<ransomNote.length();i++)
        {
            arr1[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++)
        {
            arr2[magazine.charAt(i)-'a']++;
        }
        
        for(int i=0;i<arr1.length;i++)
        {
            if(arr2[i]<arr1[i])
                return false;
        }
        return true;
        
    }
}