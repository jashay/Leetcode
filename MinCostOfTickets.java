import java.util.*;
public class MinCostOfTickets {
  int[] memo = new int[366];
  public int dfs(int i, int[] days, int[] costs, Set<Integer> set) {
      if (i >365) return 0;
      
      if (memo[i] != -1) return memo[i];
      
      int min;
      if (set.contains(i)) {
          min = Math.min(dfs(i+1, days, costs, set) + costs[0], dfs(i+7, days, costs,set) + costs[1]);
          min = Math.min(min, dfs(i+30, days, costs, set) + costs[2]);
      }
      else min = dfs(i+1, days, costs, set);
      
      return memo[i] = min;
  }
    
  public int mincostTickets(int[] days, int[] costs) {
      Set<Integer> set = new HashSet();
      Arrays.fill(memo, -1);
      for (int x : days) set.add(x);
      return dfs(0, days, costs, set);
  }
}
