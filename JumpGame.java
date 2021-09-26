import java.util.*;
public class JumpGame {
  public boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    Arrays.fill(dp, false);
    dp[nums.length-1] = true;
    for (int i=nums.length-2;i>=0; i--) {
        for (int j=1; j<=nums[i]; j++) {
            if (i+j < nums.length && dp[i+j]==true) {
                dp[i] = true;
            }
        }
    }
    
    return dp[0];
}
}
