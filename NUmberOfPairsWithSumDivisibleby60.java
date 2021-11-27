import java.util.*;
public class NUmberOfPairsWithSumDivisibleby60 {
  public int numPairsDivisibleBy60(int[] time) {
    // Two sum variation
    
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for (int t : time) {
        int diff = 60 - t % 60;
        
        if (t%60 != 0 && map.containsKey(diff)) {
            ans += map.get(diff);
        }
        else if (t%60 == 0 && map.containsKey(0)) {
            ans += map.get(0);
        }
        
        map.put(t%60, map.getOrDefault(t%60, 0) +1);
    }
    
    return ans;
}
}
