class Solution {
    public void rotate(int[][] matrix) {
        Approach1(matrix);
       // Approach2(matrix);
    }
    public void Approach1(int[][] matrix)
    {
        int temp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                temp[j][matrix[0].length-1-i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j]=temp[i][j];
            }
        }
    }
    public void Approach2(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(i<j)
                {
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            int start = 0, end = matrix[i].length-1;
            while(start<end)
            {
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;
            }
        }
    }
}