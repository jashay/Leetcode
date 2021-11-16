public class MinDelToRemoveRepeatedChars {
  public int minCost(String s, int[] cost) {
    char[] chars = s.toCharArray();
    char prev = chars[0];
    int ans = 0, maxCost = cost[0];
    for (int i=1; i<chars.length; i++) {
        if (chars[i] == prev) {
            ans += Math.min(maxCost, cost[i]);
            maxCost = Math.max(maxCost, cost[i]);
        }
        else {
            prev = chars[i];
            maxCost = cost[i];
        }
    }
    
    return ans;
  }
}
