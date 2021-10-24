import java.util.*;
class TimeToInformEmployee {
  class Pair {
    int minutes;
    int employeeId;
    List<Integer> list;
    
    public Pair(int m, int e, List<Integer> l) {
        this.minutes = m;
        this.employeeId = e;
        this.list = l;
    }
}

public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, Pair> map = new HashMap<>();
    
    for (int i=0; i<n; i++) {
        if (map.containsKey(manager[i])) {
            Pair p = map.get(manager[i]);
            p.list.add(i);
        }
        else {
            if (manager[i] >= 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(manager[i], new Pair(informTime[manager[i]],manager[i],list));
            }
        }
        
    }
    
    Queue<Integer> q = new LinkedList<>();
    q.add(headID);
    int max = 0;
    while (!q.isEmpty()) {
        int emp = q.poll();
        if (!map.containsKey(emp)) continue;
        Pair p = map.get(emp);
        for (int x : p.list) {
            if (map.containsKey(x)) {
                map.get(x).minutes += map.get(p.employeeId).minutes;
                if (map.get(x).list.isEmpty()) {
                    // leaf!
                    max = Math.max(max, map.get(x).minutes);
                }
                q.add(x);
            }
        }
        
    }
    
    
    return max;
    
}
}