import java.util.*;
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) { 
    if (nums.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    
    for (int x : nums) {
        set.add(x);
    }
    
    int maxSize = 1;
    for (int num : set) {
        if (!set.contains(num-1)) {
            int currSize = 1;
            while (set.contains(num+1)) {
                currSize++;
                num++;
            }
            maxSize = Math.max(maxSize, currSize);
        }
    }
    
    return maxSize;
  }
}
