import java.util.*;
public class HitCounter {
  Deque<Integer> deque;
    int size;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        deque = new LinkedList<Integer>();
        size = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        deque.add(timestamp);
        size++;
        
        return;
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.peekFirst() <= timestamp - 300 ) {
            deque.pollFirst();
            size--;
        }
        return size;
    }
}
