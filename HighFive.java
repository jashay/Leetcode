import java.util.*;
public class HighFive {
  public int[][] highFive(int[][] items) {
    Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    
    for (int[] i : items) {
        List<Integer> list;
        if (map.containsKey(i[0])) {
            list = map.get(i[0]);
        }
        else {
            list = new ArrayList<>();
        }
        list.add(i[1]);
        map.put(i[0], list);
    }
    List<int[]> res = new ArrayList<>();
    
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        List<Integer> li = entry.getValue();
        Collections.sort(li, (a,b) -> b-a);
        
        int sum = 0;
        for (int i=0; i<5; i++) {
            sum+=li.get(i);
        }
        int avg = sum/5;
        
        res.add(new int[]{entry.getKey(), avg});
    }
    
    int[][] ans=new int[res.size()][2];
    
    for (int i=0; i<res.size(); i++) {
        ans[i] = res.get(i);
    }
    
    Arrays.sort(ans, (a,b) -> a[0] - b[0]);
    
    return ans;
    
  }
}
