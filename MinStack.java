import java.util.*;
class MinStack {
    
  class Node {
      int min;
      int val;
      
      public Node(int v, int m) {
          this.val = v;
          this.min = m;
      }
  }
  
  Stack<Node> stack;

  /** initialize your data structure here. */
  public MinStack() {
      stack = new Stack<>();
  }
  
  public void push(int val) {
      
      if (stack.isEmpty()) {
          int min = val;
          stack.push(new Node(val, min));
          return;
      }
      
      Node n = stack.peek();
      int min = val;
      min = Math.min(min, n.min);
      stack.push(new Node(val, min));
  }
  
  public void pop() { 
      stack.pop();
  }
  
  public int top() {
      return stack.peek().val;
  }
  
  public int getMin() {
      return stack.peek().min;
  }
}

