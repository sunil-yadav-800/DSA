class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++)
        {
            int paperLeft = citations.length-i;
            if(citations[i]>=paperLeft)
            {
                return paperLeft;
            }
        }
        return 0;
    }
}