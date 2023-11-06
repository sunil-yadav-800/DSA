class Solution {
    public int[] replaceElements(int[] arr) {
       /* first approach
        for(int i=0;i<arr.length-1;i++)
        {
            int max=0;
            for(int j=i+1;j<arr.length;j++)
            {
                max=Math.max(max,arr[j]);
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
        
        */
        if(arr.length==1)
        {
            arr[0]=-1;
            return arr;
        }
        
        int max=arr[arr.length-1];
        arr[arr.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--)
        {
            int num=arr[i];
            arr[i]=max;
            max=Math.max(max,num);
        }
        
        return arr;
    }
}