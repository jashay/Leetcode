import java.util.*;
class ContinuousSubarraySum {
  public boolean checkSubarraySum(int[] nums, int k) {
        //Using modular logic
        
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        map.put(0, -1);
        
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum % k)) {
                if (i-map.get(sum %k) >=2) return true;
                else continue;
            }
            else {
                map.put(sum%k, i);
            }
        }
    
        return false;
    }
}