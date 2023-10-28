class Solution {
    public String gcdOfStrings(String str1, String str2) {
        return Approach1(str1,str2);
    }
    private String Approach1(String str1, String str2)
    {
        for(int i=Math.min(str1.length(),str2.length());i>=0;i--)
        {
            if(isValid(str1,str2,i))
            {
                return str1.substring(0,i);
            }
        }
        return "";
    }
    private boolean isValid(String str1, String str2, int k)
    {
        String base = str1.substring(0,k);
        if(str1.replace(base,"").isEmpty() && str2.replace(base,"").isEmpty())
            return true;
        return false;
    }
}