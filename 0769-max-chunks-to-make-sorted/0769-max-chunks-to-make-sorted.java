class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxValue = 0;
        int totalChunks = 0;
        for(int i=0;i<arr.length;i++)
        {
            maxValue = Math.max(maxValue,arr[i]);
            if(maxValue == i)
                totalChunks++;
        }
        return totalChunks;
    }
}