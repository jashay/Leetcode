import java.util.*;
public class ExclusiveTimeOfFunctions {
  public int[] exclusiveTime(int n, List<String> logs) {
        
    int[] ans = new int[n];
    Stack<Integer> stack = new Stack();
    int startTimestamp = 0;
    for (String log : logs) {
        String[] logArray = log.split(":");
        int f = Integer.parseInt(logArray[0]);
        int t = Integer.parseInt(logArray[2]);
        if (logArray[1].equals("start")) {
            if (!stack.isEmpty()) {
                ans[stack.peek()] += t-startTimestamp;
            }
            stack.push(f);
            startTimestamp = t;
        }
        else {
            ans[stack.peek()] += t-startTimestamp +1;
            startTimestamp = t+1;
            stack.pop();
        }
        
    }
    
    
    return ans;
}
}
