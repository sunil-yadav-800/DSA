class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        int carry=1;
        int index=digits.length-1;
        while(index>=0)
        {
            int sum = digits[index] + carry;
            list.add(0,sum%10);
            carry = sum/10;
            index--;
        }
        if(carry>0)
        {
            list.add(0,carry);
        }
        
        int []ans = new int[list.size()];
        
        for(int i=0;i<list.size();i++)
        {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}