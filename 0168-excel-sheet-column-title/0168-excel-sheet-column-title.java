class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0)
        {
            int rem = (columnNumber-1)%26;
            char ch = (char)(rem+'A');
            sb.append(ch);
            columnNumber = (columnNumber-1)/26;
        }
        return sb.reverse().toString();
    }
}