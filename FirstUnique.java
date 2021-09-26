import java.util.*;
public class FirstUnique {
  Set<Integer> set = new HashSet();
  Deque<Integer> unique = new LinkedList();
  public FirstUnique(int[] nums) {
      for (int x : nums) {
          if (!set.contains(x)) {
              set.add(x);
              unique.addLast(x);
          }
      }
  }
  
  public int showFirstUnique() {
      return unique.peekFirst();
  }
  
  public void add(int value) {
      if (!set.contains(value)) {
          unique.addLast(value);
          set.add(value);
      } 
      else {
          while (unique.peekFirst() == value) {
              unique.pollFirst();
          }
      }
  }
}
