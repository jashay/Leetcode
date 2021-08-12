import java.util.*;
public class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    
    for (int num : nums) {
        maxHeap.offer(num);
    }
    int temp=0;
    while (k >0) {
        temp = maxHeap.poll();
        k--;
    }
    
    return temp;
  }
}
