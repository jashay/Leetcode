import java.util.*;
public class SingleElementInArray {
  public int singleNonDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0)+1);
    }
    
    for (int key : map.keySet()) {
        int c = map.get(key);
        if (c==1) {
            return key;
        }
    }
    
    return -1;
}
}
