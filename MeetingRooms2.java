import java.util.*;
public class MeetingRooms2 {
  public int minMeetingRooms(int[][] intervals) {
    int maxUsed = 0;
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    
    Queue<Integer> minHeap = new PriorityQueue<>();
    
    for (int i=0; i<intervals.length; i++) {
        
        if (minHeap.isEmpty()) {
            minHeap.add(intervals[i][1]);
            maxUsed = Math.max(maxUsed, minHeap.size());
        }
        else if (minHeap.size()>0 && minHeap.peek() > intervals[i][0]) {
            minHeap.add(intervals[i][1]);
            maxUsed = Math.max(maxUsed, minHeap.size());
        }
        else if(minHeap.size()>0 && minHeap.peek()<=intervals[i][0]) {
            while (minHeap.size()>0 && minHeap.peek()<=intervals[i][0])
                minHeap.poll();
            minHeap.add(intervals[i][1]);
        }
    }
    
    return maxUsed;
}
}
