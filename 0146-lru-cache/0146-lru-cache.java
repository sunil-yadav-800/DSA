class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int value)
    {
        this.key=key;
        this.val=value;
        prev=null;
        next=null;
    }
}
class LRUCache {
    Node left;
    Node right;
    int capacity;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        left = new Node(0,0);
        right = new Node(0,0);
        left.next=right;
        right.prev=left;
        this.capacity=capacity;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        map.put(key,new Node(key,value));
        insert(map.get(key));
        if(map.size()>capacity)
        {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
    public void remove(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next=next;
        next.prev=prev;
    }
    public void insert(Node node)
    {
        Node prev = right.prev;
        
        prev.next=node;
        node.prev=prev;
        
        node.next=right;
        right.prev=node;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */