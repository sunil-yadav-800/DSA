class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size()-minHeap.size()>1)
        {
            minHeap.add(maxHeap.poll());
        }
        
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek()>minHeap.peek())
        {
            //swap both peek elements
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
        {
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        }
        else
        {
            return (double)maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */