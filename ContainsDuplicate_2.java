import java.util.*;
public class ContainsDuplicate_2 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    for (int i=0;i<nums.length; i++) {
        int num = nums[i];
        if (map.containsKey(num)) {
            List<Integer> list = map.get(num);
            list.add(i);
            map.put(num, list);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(num, list);
        }
    }
    
    
    for (int key : map.keySet()) {
        List<Integer> list = map.get(key);
        if (list.size() >1) {
            int first = list.get(0);
            for (int x = 1; x<list.size(); x++) {
                int second = list.get(x);
                if (Math.abs(first-second) <=k) {
                    return true;
                }
                first = second;
            }
        }
    }
    
    return false;
}
}
