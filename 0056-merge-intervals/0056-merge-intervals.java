public class sortByStartTime implements Comparator<int[]>{
    public int compare(int[] first, int[] second)
    {
        return first[0]-second[0];
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new sortByStartTime());
        ArrayList<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(end>=s)
            {
                end = Math.max(end,e);
            }
            else
            {
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
    }
}