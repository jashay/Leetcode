import java.util.*;
public class CheckIfExist {
  public boolean checkIfExist(int[] arr) {
    Set<Integer> set = new HashSet<>();
    int count = 0;
    for (int num : arr) {
        if (num == 0) count++;
        set.add(num);
    }
    
    for (int key : set) {
        if (key != 0 && set.contains(key*2)) {
            return true;
        }
        if (key == 0) {
            if (count > 1) return true;
        }
    }
    
    return false;
  }
}
