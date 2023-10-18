class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))
            {
                char ch = s.charAt(i);
                if(ch>='A' && ch<='Z')
                {
                    ch=(char)(ch+32);
                   // ch = Character.toLowerCase(ch);
                }
                sb.append(ch);
            }
        }
        String modifiedString = sb.toString(); // new String(sb);
        return checkPalindrome(modifiedString);
    }
    public boolean checkPalindrome(String str)
    {
        System.out.println(str);
        int start=0,end=str.length()-1;
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}