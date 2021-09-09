import java.util.*;
class CombinationSum {
  public void recursive(int[] candidates, int target, int i, List<Integer> curr, List<List<Integer>> ans) {
    if (target < 0) {
        return;
    }
    else if (target == 0) {
        ans.add(new ArrayList<>(curr));
    }
    else {
        for (int x=i; x<candidates.length; x++) {
            curr.add(candidates[x]);
            recursive(candidates, target-candidates[x], x, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
    
}

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      
      List<List<Integer>> ans = new ArrayList<>();
      
      recursive(candidates, target, 0, new ArrayList<>(), ans);
      
      return ans;
  }
}