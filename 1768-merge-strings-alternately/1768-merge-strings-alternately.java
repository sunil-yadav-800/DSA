class Solution {
    public String mergeAlternately(String word1, String word2) {
        
//         String ans = new String();
//         int i=0,j=0;
//         while(i<word1.length() && j<word2.length())
//         {
//             ans = ans+word1.charAt(i)+word2.charAt(j);
//             i++;
//             j++;
            
//         }
//         while(i<word1.length())
//         {
//             ans= ans+word1.charAt(i);
//             i++;
//         }
        
//         while(j<word2.length())
//         {
//             ans= ans+word2.charAt(j);
//             j++;
//         }
        
//         return ans;
        
        
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        while(i<word1.length() || j<word2.length())
        {
            if(i<word1.length())
            {
                sb.append(word1.charAt(i++));
            }
            if(j<word2.length())
            {
                sb.append(word2.charAt(j++));
            }
        }
        
        return sb.toString();
    }
}