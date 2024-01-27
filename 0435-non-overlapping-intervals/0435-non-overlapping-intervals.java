class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //approach
        //sort the array by end time in asc order
        // count the no. of intervals that are not overlapping i.e count.
        // no. of overlapping that i need to remove = length-count
        
        
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=1;
        int prev=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]>=intervals[prev][1])
            {
                count++;
                prev=i;
            }
        }
        
        return intervals.length-count;
    }
}