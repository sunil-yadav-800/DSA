class Node{
    Node[] links = new Node[26];
    boolean flag=false;
    public Node(){
        
    }
    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }
    public void put(char ch, Node node)
    {
        links[ch-'a']=node;
    }
    public Node get(char ch)
    {
        return links[ch-'a'];
    }
    public void setEnd(){
        flag=true;
    }
    public boolean getEnd()
    {
        return flag;
    }
    
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i))) // node.links[word.charAt(i)-'a']!=null
            {
                node.put(word.charAt(i), new Node());
                // node.links[word.charAt(i)-'a']=new node()
            }
            node = node.get(word.charAt(i));//node = node.links[word.charAt(i)-'a']
        }
        node.setEnd(); //to indicate that we contains this word
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node.getEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++)
        {
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */