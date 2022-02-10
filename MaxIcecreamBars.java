import java.util.*;
public class MaxIcecreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        for (int x : costs) {
            minHeap.offer(x);
        }
        int counter =0;
        while (coins > 0 && !minHeap.isEmpty()) {
            int x = minHeap.poll();
            if (x <= coins) {
                counter++;
                coins-=x;
            }
        }
        
        return counter;
    }
}
