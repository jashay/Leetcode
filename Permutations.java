import java.util.*;
class Permutations {
  public void recursive(int[] nums, int start, List<Integer> curr, List<List<Integer>> ans) {
        
    if (curr.size() == nums.length) {
        ans.add(new ArrayList<>(curr));
    }
    for (int i=0; i<nums.length; i++) {
        if (curr.contains(nums[i])) continue;
        curr.add(nums[i]);
        recursive(nums, i+1, curr, ans);
        curr.remove(curr.size()-1);
    }
}

  public List<List<Integer>> permute(int[] nums) {
      
      List<List<Integer>> ans = new ArrayList<>();
      
      recursive(nums, 0, new ArrayList<>(), ans);
      
      return ans;
  }
}
