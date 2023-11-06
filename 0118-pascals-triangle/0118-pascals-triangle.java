class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(i>0 && j>0 && j<i)
                {
                    int value = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    list.add(value);
                }
                else
                {
                    list.add(1);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}