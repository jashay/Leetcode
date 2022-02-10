import java.util.*;
class RandomPickIndex {
  Map<Integer, List<Integer>> map = new HashMap<>();
  public RandomPickIndex(int[] nums) {
      for (int i=0; i<nums.length; i++) {
          int num = nums[i];
          map.putIfAbsent(num, new ArrayList<>());
          map.get(num).add(i);
      }
  }
  
  public int pick(int target) {
      if (!map.containsKey(target)) return -1;
      
      Random rand = new Random();
      List<Integer> indexes = map.get(target);
      return indexes.get(rand.nextInt(indexes.size()));
  }
}