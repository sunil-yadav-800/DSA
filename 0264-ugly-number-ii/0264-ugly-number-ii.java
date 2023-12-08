class Solution {
    public int nthUglyNumber(int n) {
        return solve(n);
    }
    public int solve(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i=0,j=0,k=0;
        while(list.size()<n)
        {
            int nextUglyNumber = Math.min(list.get(i)*2,Math.min(list.get(j)*3,list.get(k)*5));
            list.add(nextUglyNumber);
            if(list.get(i)*2 == nextUglyNumber)
            {
                i++;
            }
            if(list.get(j)*3 == nextUglyNumber)
            {
                j++;
            }
            if(list.get(k)*5 == nextUglyNumber)
            {
                k++;
            }
        }
        return list.get(list.size()-1);
        
    }
}