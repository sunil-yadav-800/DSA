class Solution {
    public int lengthOfLastWord(String s) {
        int lastSpaceIndex=-1;
        int length = s.length();
        int i=length-1;
        while(i>=0 && s.charAt(i)==' ')
        {
            i--;
        }
        lastSpaceIndex=i+1;
        while(i>=0 && s.charAt(i)!=' ')
        {
            i--;
        }
        String lastString = s.substring(i+1,lastSpaceIndex);
        return lastString.length();
    }
}