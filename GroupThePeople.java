import java.util.*;
public class GroupThePeople {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> ans = new ArrayList<>();
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    for (int i=0; i<groupSizes.length; i++) {
        List<Integer> list;
        if (map.containsKey(groupSizes[i])) {
             list = map.get(groupSizes[i]);
        }
        else {
            list = new ArrayList<>();                
        }
        list.add(i);
        map.put(groupSizes[i], list);
    }
    
    for (int key : map.keySet()) {
        List<Integer> list = map.get(key);
        int x = 0;
        while (x < list.size()) {
            List<Integer> temp = new ArrayList<>();
            while (temp.size() < key) {
                temp.add(list.get(x));
                x++;
            }
            ans.add(temp);
        }
    }
    
    return ans;
}
}
