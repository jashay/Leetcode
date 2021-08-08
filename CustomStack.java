import java.util.*;
class CustomStack {
    
  Stack<Integer> stack;
  int maxSize, currentSize;
  
  public CustomStack(int maxSize) {
      this.stack = new Stack<>();
      this.maxSize = maxSize;
      this.currentSize = 0;
  }
  
  public void push(int x) {
      if (currentSize < maxSize) {
          stack.push(x);
          currentSize++;
      }
  }
  
  public int pop() {
      if (stack.isEmpty()) return -1;
      
      currentSize--;
      return stack.pop();
   }
  
  public void increment(int k, int val) {
      if (k>currentSize) {
          k=currentSize;
      }
      
      for (int i=0; i<k; i++) {
          stack.set(i, stack.get(i)+val);
      }
  }
}

/**
* Your CustomStack object will be instantiated and called as such:
* CustomStack obj = new CustomStack(maxSize);
* obj.push(x);
* int param_2 = obj.pop();
* obj.increment(k,val);
*/