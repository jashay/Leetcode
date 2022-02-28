import java.util.*;
public class FirstUnique {
  Set<Integer> set;
  Set<Integer> dup;
  public FirstUnique(int[] nums) {
      set = new LinkedHashSet<>();
      dup = new HashSet<>();
      
      for (int num : nums) {
          if (!set.contains(num) && !dup.contains(num)) {
              set.add(num);
          }
          else {
              set.remove(num);
              dup.add(num);
          }
      }
  }
  
  public int showFirstUnique() {
      for (int ans : set) {
          return ans;
      }
      return -1;
  }
  
  public void add(int value) {
      int num = value;
      if (!set.contains(num) && !dup.contains(num)) {
              set.add(num);
          }
          else {
              set.remove(num);
              dup.add(num);
          }
  }
}
