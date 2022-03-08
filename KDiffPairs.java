import java.util.*;
public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int val = entry.getValue();
            if ((k > 0 && map.containsKey(x + k)) || (k == 0 && val > 1)) ans++;
        }
        
        return ans;
    }
}
