public class EmployeeFreeTime {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    Queue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.start - b.start);
    
    for (List<Interval> l : schedule) {
        for (Interval i : l) {
            minHeap.add(i);
        }
    }
    int currstart = minHeap.poll().end;
    List<Interval> list = new ArrayList();
    while (!minHeap.isEmpty()) {
        Interval curr = minHeap.poll();
        if (curr.start <= currstart) {
            currstart= Math.max(currstart, curr.end);
        }
        else {
            list.add(new Interval(currstart, curr.start));
            currstart = curr.end;
        }
        
    }
    
    
    return list;
  }
}
