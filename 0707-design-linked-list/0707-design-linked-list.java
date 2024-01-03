class Node{
    int val;
    Node next;
    public Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}
class MyLinkedList {
    Node head;
    int count=0;
    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        if(index>=count)
            return -1;
        Node curr=head;
        for(int i=1;i<=index;i++)
        {
            curr=curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next=head;
        head=newNode;
        count++;
    }
    
    public void addAtTail(int val) {
        if(head == null)
        {
            addAtHead(val);
            return;
        }
        Node curr = head;
        while(curr.next!=null)
        {
            curr=curr.next;
        }
        Node newNode = new Node(val);
        curr.next=newNode;
        count++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>count)
            return ;
        if(index == count)
        {
            addAtTail(val);
            return;
        }
        if(index == 0)
        {
            addAtHead(val);
            return;
        }
        Node curr=head;
        for(int i=1;i<index;i++)
        {
            curr=curr.next;
        }
        Node newNode = new Node(val);
        Node nextNode = curr.next;
        curr.next=newNode;
        newNode.next = nextNode;
        count++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >=count)
            return;
        if(index == 0)
        {
            head=head.next;
            count--;
        }
        else
        {
            Node curr=head;
            for(int i=1;i<index;i++)
            {
                curr=curr.next;
            }
            Node nextNode = curr.next.next;
            curr.next=nextNode;
            count--;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */