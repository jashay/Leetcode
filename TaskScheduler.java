import java.util.*;
class TaskScheduler {
  public class Task {
    char name;
    int cooldown, count;
    public Task(char c, int count, int cooldown) {
        this.name = c;
        this.count = count;
        this.cooldown = cooldown;
    }
}

public int leastInterval(char[] tasks, int n) {
    Queue<Task> maxHeap = new PriorityQueue<>((a,b) -> b.count - a.count);
    Map<Character, Integer> map = new HashMap<>();
    
    for (char c : tasks) {
        map.put(c, map.getOrDefault(c, 0)+1);
    }
    
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        maxHeap.offer(new Task(entry.getKey(), entry.getValue(), 0));
    }
    
    int counter = 0;
    
    while (!maxHeap.isEmpty()) {
        int k=n+1;
        List<Task> l = new ArrayList<>();
        while (k>0 && !maxHeap.isEmpty()) {
            Task t = maxHeap.poll();
            t.count--;
            l.add(t);
            k--;
            counter++;
        }
        
        for (Task t : l) {
            if(t.count >0) maxHeap.offer(t);
        }
        if (maxHeap.isEmpty()) break;
        counter += k;
    }
    return counter;
}
}