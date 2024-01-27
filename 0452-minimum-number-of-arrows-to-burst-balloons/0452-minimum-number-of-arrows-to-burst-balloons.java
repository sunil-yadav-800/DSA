public class sortByEndTime implements Comparator<int[]>{
    public int compare(int[] a, int[] b)
    {
        long first = (long)a[1];
        long second = (long)b[1];
        if(first>second)
            return 1;
        else if(first<second)
            return -1;
        else
            return 0;
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort the array by end time in asc order
        //count non overlapping intervals
        
        Arrays.sort(points,new sortByEndTime());
        int ans=1; //minimum one arrow is required
        int prev=0;
        for(int i=1;i<points.length;i++)
        {
            if((long)(points[i][0]) > (long)(points[prev][1]))
            {
                ans++;
                prev=i;
            }
        }
        return ans;
    }
}