class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++)
        {
            mini = Math.min(mini,Math.abs(arr[i]-arr[i-1]));
        }
        for(int i=0;i<arr.length-1;i++)
        {
            int diff = Math.abs(arr[i+1]-arr[i]);
            if(diff == mini)
            {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }
        return ans;
    }
}