import java.util.*;
public class MinimumCostToConectSticks {
  public int connectSticks(int[] sticks) {
    Queue<Integer> q = new PriorityQueue<>();
    
    for (int x : sticks) {
        q.offer(x);
    }
    int total = 0;
    while (q.size() > 1) {
        int n1 = q.poll();
        int n2 = q.poll();
        total += n1+n2;
        q.offer(n1+n2);
    }
    
    return total;
}
}
