import java.util.*;
public class CombinationSum_2 {
  public void recursive(int[] candidates, int target, int start, List<List<Integer>> ans, List<Integer> curr) {
        
    if (target < 0) return;
    
    if (target == 0) {
        ans.add(new ArrayList<>(curr));
        return;
    }
    
    for (int i=start; i<candidates.length; i++) {
        if (i>start && candidates[i] == candidates[i-1]) continue;
        curr.add(candidates[i]);
        recursive(candidates, target-candidates[i], i+1, ans, curr);
        curr.remove(curr.size()-1);
    }
}


  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      
      List<List<Integer>> ans = new ArrayList<>();
      Arrays.sort(candidates);
      recursive(candidates, target, 0, ans, new ArrayList<>());
      
      return ans;
  }
}
