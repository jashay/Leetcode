import java.util.*;
public class KClosestPointToOrigin {
  public int distance(int p1, int p2) {
    return p1*p1 + p2*p2;
}


public int[][] kClosest(int[][] points, int k) {
    Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> distance(a[0],a[1]) - distance(b[0],b[1])); 
    
    int[][] ans = new int[k][2];
    
    for (int[] point : points) {
        minHeap.offer(point);
    }
    
    int i=0;
    while (i<k) {
        ans[i] = minHeap.poll();
        i++;
    }
    
    return ans;
}
}