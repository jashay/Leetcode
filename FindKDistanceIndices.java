import java.util.*;
public class FindKDistanceIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == key) {
                for(int x = i-k; x<=Math.min(i+k,nums.length-1); x++) {
                    if (x >= 0) {
                        set.add(x);
                    }
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}
