import java.util.*;
public class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    
    for (int num : nums1) {
        if (!set.contains(num)) set.add(num);
    }
    List<Integer> ans = new ArrayList<>();
    for (int x : nums2) {
        if (set.contains(x)) {
            ans.add(x);
            set.remove(x);
        }
    }
    int[] arr = new int[ans.size()];
    for (int i=0; i<ans.size(); i++) {
        arr[i] = ans.get(i);
    }
    
    return arr;
}
}
