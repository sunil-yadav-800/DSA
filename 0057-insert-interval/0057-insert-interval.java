class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans  = new ArrayList<>();
        if(intervals.length == 0)
        {
            ans.add(new int[]{newInterval[0],newInterval[1]});
           return ans.toArray(new int[0][]);
        }
        boolean flag = false;
        for(int i=0;i<intervals.length;i++)
        {
            if(flag || newInterval[0]>intervals[i][1])
            {
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else if(intervals[i][0]>newInterval[1])
            {
                ans.add(new int[]{newInterval[0],newInterval[1]});
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
                flag=true;
            }
            else
            {
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
                
        }
        if(flag == false)
        {
            ans.add(new int[]{newInterval[0],newInterval[1]});
        }
        return ans.toArray(new int[0][]);
    }
}