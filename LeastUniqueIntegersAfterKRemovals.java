import java.util.*;
public class LeastUniqueIntegersAfterKRemovals {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    List<int[]> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int x : arr) {
        if (map.containsKey(x)) {
            int count = map.get(x);
            map.put(x, count+1);
        }
        else {
            map.put(x, 1);
        }
    }
    
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int[] t = new int[2];
        t[0] = entry.getKey();
        t[1] = entry.getValue();
        
        list.add(t);
    }
    
    Collections.sort(list, (a, b) -> a[1] - b[1]);
    
    int i=0;
    
    while (k> 0) {
        while (k>0 && list.get(0)[1] >0) {
            int c = list.get(0)[1];
            int u = list.get(0)[0];
            c--;
            k--;
            list.set(0, new int[]{u, c});
        }
        if (list.get(0)[1] ==0) list.remove(0);
    }
    
    
    return list.size();
  }
}
