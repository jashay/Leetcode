import java.util.*;
public class MinDeletionsToUnique {
  public int minDeletions(String s) {
        
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c-'a']++;
    }
    
    Arrays.sort(count);
    int ans =0;
    Set<Integer> set = new HashSet<>();
    for (int i= count.length-1; i>=0; i--) {
        while (count[i] != 0 && set.contains(count[i])) {
            count[i]--;
            ans++;
        }
        if (count[i] != 0) set.add(count[i]);
    }
    
    return ans;
  }
}
