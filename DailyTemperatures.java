import java.util.*;
class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<int[]> stack = new Stack();
    int[] ans = new int[temperatures.length];
    for (int i=0; i<temperatures.length; i++) {
        
        if (!stack.isEmpty() && stack.peek()[1] >= temperatures[i]) {
            stack.push(new int[] {i, temperatures[i]});
        }
        else {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] top = stack.pop();
                ans[top[0]] = i-top[0];
            }
            stack.push(new int[] {i, temperatures[i]});
        }
    }
    
    return ans;
}
}