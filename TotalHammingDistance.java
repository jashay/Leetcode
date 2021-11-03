public class TotalHammingDistance {
  public int totalHammingDistance(int[] nums) {
    int total = 0;
    int[] ans = new int[32];
    for (int i=0; i<=31; i++) {
        for (int num : nums) {
            int t = (num >> i);
            ans[i] += t & 1;
        }
    }
    
    for (int i=0; i<=31; i++) {
        total += ans[i] * (nums.length - ans[i]);
    }
    
    return total;
  }
}
