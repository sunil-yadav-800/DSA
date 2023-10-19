class Solution {
    public int maxChunksToSorted(int[] arr) {
        //return Approach1(arr);
        return Approach2(arr);
    }
    public int Approach1(int[] arr)
    {
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];
        leftMax[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        rightMin[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
        }
        int ans=1;
        for(int i=0;i<arr.length-1;i++)
        {
            if(leftMax[i]<=rightMin[i+1])
                ans++;
        }
        return ans;
    }
    public int Approach2(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        int large=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && st.peek()>arr[i])
            {
                st.pop();
            }
            large = Math.max(large,arr[i]);
            st.push(large);
        }
        return st.size();
    }
}