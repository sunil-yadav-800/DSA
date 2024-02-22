class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        DFS(sr,sc,image[sr][sc],image);
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[0].length;j++)
            {
                if(image[i][j]==-1)
                {
                    image[i][j]=color;
                }
            }
        }
        return image;
    }
    private void DFS(int sr, int sc, int initColor, int[][] image)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] !=initColor){
            return;
        }
        
        image[sr][sc]=-1;
        DFS(sr+1,sc,initColor,image);
        DFS(sr-1,sc,initColor,image);
        DFS(sr,sc+1,initColor,image);
        DFS(sr,sc-1,initColor,image);
    }
}