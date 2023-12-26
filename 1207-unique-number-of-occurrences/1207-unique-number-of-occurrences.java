class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> itr: map.entrySet())
        {
            if(set.contains(itr.getValue()))
                return false;
            set.add(itr.getValue());
        }
        return true;
    }
}