class Solution {
    public int maxPoints(int[][] points) {
        int ans=1;
        
        for(int i=0;i<points.length;i++)
        {
            HashMap<Double,Integer> map = new HashMap<>();
            for(int j=i+1;j<points.length;j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1==x2)
                {
                    map.put(Double.MAX_VALUE,map.getOrDefault(Double.MAX_VALUE,0)+1);
                    ans=Math.max(ans,map.get(Double.MAX_VALUE)+1);
                }
                else if(y1==y2)
                {
                    map.put(Double.MIN_VALUE,map.getOrDefault(Double.MIN_VALUE,0)+1);
                    ans=Math.max(ans,map.get(Double.MIN_VALUE)+1);
                }
                else
                {
                    double slope = (double)(y2-y1)/(double)(x2-x1);
                    map.put(slope,map.getOrDefault(slope,0)+1);
                    ans=Math.max(ans,map.get(slope)+1);
                }
            }
           
        }
        return ans;
        
    }
}