class Solution {
    public int minSwaps(String s) {
        int extraOpeningBrackets=0,max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==']')
            {
                extraOpeningBrackets++;
                max=Math.max(extraOpeningBrackets,max);
            }
            else
            {
                extraOpeningBrackets--;
            }
        }
        return (max+1)/2;
    }
}