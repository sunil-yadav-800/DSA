class Axis{
    int x;
    int y;
    public Axis(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}
class sortByDistance implements Comparator<Axis>{
    public int compare(Axis a, Axis b)
    {
        double sq1 = Math.sqrt(Math.pow(a.x,2) + Math.pow(a.y,2));
        double sq2 = Math.sqrt(Math.pow(b.x,2) + Math.pow(b.y,2));
        if(sq1<sq2)
        {
            return -1;
        }
        else if(sq1>sq2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Axis[] axiss = new Axis[points.length];
        for(int i=0;i<points.length;i++)
        {
            axiss[i] = new Axis(points[i][0],points[i][1]);
        }
        Arrays.sort(axiss, new sortByDistance());
        
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++)
        {
            ans[i][0]=axiss[i].x;
            ans[i][1]=axiss[i].y;
        }
        return ans;
    }
}