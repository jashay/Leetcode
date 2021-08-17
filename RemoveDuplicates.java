import java.util.*;
public class RemoveDuplicates {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    
    for (int num : nums) {
        if (set.contains(num)) {
            ans.add(num);
        }
        else {
            set.add(num);
        }
    }
    
    return ans;
  }
}
