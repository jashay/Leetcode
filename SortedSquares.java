import java.util.*;
public class SortedSquares {
  public int[] sortedSquares(int[] nums) {
    Stack<Integer> stack = new Stack<>();

    for (int x : nums) {
        if (x>=0) break;
        stack.push(x*x);
    }
    int start = stack.size();
    List<Integer> ans = new ArrayList<>();
    for (int i=start; i<nums.length; i++) {
        nums[i] *= nums[i];
        while (!stack.isEmpty() && stack.peek() < nums[i]) {
            ans.add(stack.pop());
        }
        ans.add(nums[i]);
    }
    while (!stack.isEmpty()) ans.add(stack.pop());
    int[] res = new int[ans.size()];
    for (int i=0; i<ans.size(); i++) {
        res[i] = ans.get(i);
    }
    return res;
}
}
