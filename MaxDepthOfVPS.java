public class MaxDepthOfVPS {
  public int maxDepth(String s) {
    int max = 0;
    int open=0;
    for (char c : s.toCharArray()) {
        if (c == '(') {
            open++;
            max = Math.max(max, open);
        }
        else if (c == ')') open--;
    }
    
    
    return max;
}
}
