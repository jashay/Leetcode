import java.util.*;
class BuildingWithOceanView {
  public int[] findBuildings(int[] heights) {
      int maxFromLeft = 0;
      Stack<Integer> stack = new Stack();
      for (int i=heights.length-1; i>=0; i--) {
          if (heights[i] <= maxFromLeft) continue;
          else {
              stack.push(i);
              maxFromLeft = heights[i];
          }
      }
      int[] ans = new int[stack.size()];
      int i=0;
      while (!stack.isEmpty()) {
          ans[i++] = stack.pop();
      }
      
      return ans;
  }
}