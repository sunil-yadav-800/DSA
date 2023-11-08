class Solution {
    private class sortByLargestValue implements Comparator<String>{
        @Override
        public int compare(String a, String b)
        {
            String first = a+b;
            String second = b+a;
            return second.compareTo(first);
        }
    }
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new sortByLargestValue());
        if(arr[0].equals("0"))
        {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}