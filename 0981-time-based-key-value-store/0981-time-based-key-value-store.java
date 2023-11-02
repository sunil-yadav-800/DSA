class TimeMap {
HashMap<String,List<Pair<String,Integer>>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key,new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair<String,Integer>> list = map.get(key);
        return search(list,timestamp);
    }
    private String search(List<Pair<String,Integer>> list, int time)
    {
        String ans="";
        int low=0,high=list.size()-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            Pair<String,Integer> p = list.get(mid);
            if(p.getValue() == time)
            {
                return p.getKey();
            }
            else if(p.getValue()<time)
            {
                ans=p.getKey();
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */