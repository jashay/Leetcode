import java.util.*;
public class SetMismatch {
  public int[] findErrorNums(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int sum = 0, dup=0;
    
    for (int x : nums) {
        sum+=x;
        if (set.contains(x)) dup = x;
        else set.add(x);
    }
    
    int[] ans =new int[2];
    ans[0] = dup;
    sum -= dup;
    int n = nums.length;
    int correctSum = n*(n+1)/2;
    
    ans[1] = correctSum-sum;
    return ans;
}
}
