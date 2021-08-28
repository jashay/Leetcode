import java.util.*;
public class KthLargest {
  Queue<Integer> maxHeap;
    int K;
    public KthLargest(int k, int[] nums) {
        this.maxHeap = new PriorityQueue<>();
        for (int num : nums) {
            maxHeap.offer(num);
        }
        this.K = k;
        while (maxHeap.size() > K) {
            maxHeap.poll();
        }
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        while (maxHeap.size() > K) {
            maxHeap.poll();
        }
        
        return maxHeap.peek();
    }
}
