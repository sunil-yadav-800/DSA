class Pair{
    int num;
    int freq;
    Pair(int number, int frequency)
    {
        num=number;
        freq=frequency;
    }
}
class SortByFrequency implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p2.freq-p1.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Pair> list = new ArrayList<Pair>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) 
        {
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Collections.sort(list,new SortByFrequency());
        int[] ans = new int[k];
        //int index=0;
        for(int i=0;i<k;i++)
        {
            ans[i]=list.get(i).num;
        }
        return ans;
    }
}