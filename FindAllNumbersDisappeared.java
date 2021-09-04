import java.util.*;
class FindAllNumbersDisappeared {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i=0; i<n; i++) {
        map.put(nums[i]-1, map.getOrDefault(nums[i]-1,0)+1);
    }
    List<Integer> ans = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
        if (!map.containsKey(i)) {
            ans.add(i+1);
        }
    }

    
    return ans;
}
}