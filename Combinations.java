import java.util.*;
public class Combinations {
  public void recursive(int n, List<List<Integer>> a, List<Integer> curr, int start, int k) {
    if (k==0) {
        a.add(new ArrayList<>(curr));
        return;
    }
    for (int x=start; x<=n-k+1; x++) {
        curr.add(x);
        recursive(n, a, curr, x+1, k-1);
        curr.remove(curr.size()-1);
    }
    
    return;
}

  public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> ans = new ArrayList<>();
      recursive(n, ans, new ArrayList<>(), 1, k);
      
      return ans;
  }
}
