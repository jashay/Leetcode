public class SignFunction {
  public int arraySign(int[] nums) {
    int count = 0;
    for (int x : nums) {
        if (x == 0) return 0;
        else if (x < 0) count++;
    }
    
    return count %2 == 0 ? 1 : -1;
  }
}
