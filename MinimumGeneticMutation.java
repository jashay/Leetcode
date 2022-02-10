import java.util.*;
public class MinimumGeneticMutation {
  public int minMutation(String start, String end, String[] bank) {
    Map<String, Boolean> map = new HashMap<>();
    char[] charArray = {'A', 'G', 'T', 'C'};
    
    for (String mut : bank) {
        map.put(mut, false);
    }
    
    if (!map.containsKey(end)) {
        return -1;
    }
    
    Queue<String> q = new LinkedList<>();
    q.add(start);
    int count=0;
    
    while (!q.isEmpty()) {
        int size = q.size();
        while (size-- > 0) {
            String curr = q.poll(); 
            if (curr.equals(end)) return count;
            for (int i=0; i<curr.length(); i++) {
                for (char c : charArray) {
                    if (curr.charAt(i) == c) {
                        continue;
                    }
                    else {
                        String newCurr = curr.substring(0, i) + c
                        + curr.substring(i + 1);
                        if (map.containsKey(newCurr) && map.get(newCurr) == false) {
                            map.put(newCurr, true);
                            q.add(newCurr); 
                        }
                    }
                }
            }
        }
        count++;
    }
    
    return -1;
}
}
