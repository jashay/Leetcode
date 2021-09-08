public class TargetSum {
  public void dfs(int[] nums, int i, int curr, int[] ways, int target) {
    if (i==nums.length && curr == target) {
        ways[0]++;
        return;
    }
    if (i>=nums.length) return;

    dfs(nums, i+1, curr+nums[i], ways, target);
    dfs(nums, i+1, curr-nums[i], ways, target);
    
}

  public int findTargetSumWays(int[] nums, int target) {
      int[] ways = new int[1];
      
      dfs(nums, 0, 0, ways, target);
      
      return ways[0];
  }
}
