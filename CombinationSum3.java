import java.util.*;
public class CombinationSum3 {
  public void recursive(int k, int target, int start, List<List<Integer>> ans, List<Integer> curr) {
        
    if (target < 0) return;
    
    if (target == 0) {
        if (curr.size() == k)
            ans.add(new ArrayList<>(curr));
        return;
    }
    
    for (int i=start; i<=9; i++) {
        curr.add(i);
        recursive(k, target-i, i+1, ans, curr);
        curr.remove(curr.size()-1);
    }
}


  public List<List<Integer>> combinationSum3(int k, int n) {
      
      List<List<Integer>> ans = new ArrayList<>();
      recursive(k, n, 1, ans, new ArrayList<>());
      
      return ans;
  }
}
