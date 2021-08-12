import java.util.*;
public class MajorityElement2 {
  public List<Integer> majorityElement(int[] nums) {
    int targetLen = nums.length/3;
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int num : nums) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num)+1);
        }
        else {
            map.put(num, 1);
        }
    }
    
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int key = entry.getKey();
        int value= entry.getValue();
        
        if (value > targetLen) {
            list.add(key);
        }
    }
    
    
    return list;
  }
}
