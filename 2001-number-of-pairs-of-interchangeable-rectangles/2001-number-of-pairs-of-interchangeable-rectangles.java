class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Integer> map = new HashMap<>();
        long cnt=0;
        for(int row=0;row<rectangles.length;row++)
        {
            int width = rectangles[row][0];
            int height = rectangles[row][1];
            Double res = (double)width/(double)height;
            if(map.containsKey(res))
            {
                cnt+=map.get(res);
            }
            map.put(res, map.getOrDefault(res,0)+1);
        }
        return cnt;
    }
}