import java.util.*;
public class FindUserActiveMinutes {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    Map<Integer, Set<Integer>> map=  new HashMap();
    int[] ans = new int[k];
    
    for (int[] l : logs) {
        map.putIfAbsent(l[0], new HashSet());
        map.get(l[0]).add(l[1]);
    }
    
    for (int user : map.keySet()) {
        ans[map.get(user).size()-1]++;
    }
    
    return ans;
  }
}
