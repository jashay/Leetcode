import java.util.*;
public class SeatManager {
  Queue<Integer> minHeap;
    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        
        for (int i=1; i<=n; i++) {
            minHeap.offer(i);
        }
    }
    
    public int reserve() {
        return minHeap.poll();
    }
    
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}
