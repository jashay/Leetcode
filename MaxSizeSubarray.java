import java.util.*;
class MaxSizeSubarray {
  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int currSum = 0;
    for (int i=0; i<nums.length; i++) {
        currSum += nums[i];
        int diff = currSum - k;
        
        if (diff == 0) {
            max = i+1;
        }
        if (map.containsKey(diff)) {
            max = Math.max(max, i-map.get(diff));
        }
        if (!map.containsKey(currSum)) map.put(currSum, i);
    }
    
    return max;
}
}