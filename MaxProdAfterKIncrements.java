import java.util.*;
public class MaxProdAfterKIncrements {
  public int maximumProduct(int[] nums, int k) {
    long ans = 1;
    Queue<Integer> minHeap = new PriorityQueue<>();
    
    for (int x : nums) {
        minHeap.offer(x);
    }
    
    while (k > 0) {
        int min = minHeap.poll();
        min++;
        minHeap.offer(min);
        k--;
    }
    
    while (!minHeap.isEmpty()) ans = (ans*minHeap.poll()) % 1000000007;
 
    return (int)ans;
}
}
