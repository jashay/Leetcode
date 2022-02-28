import java.util.*;
class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int currSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    map.put(0, 1);
    
    for (int x : nums) {
        currSum += x;
        int diff = currSum-k;
        
        if (map.containsKey(diff)) {
            ans += map.get(diff);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0)+1);
    }
    
    return ans;
  }
}