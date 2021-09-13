import java.util.*;
public class FindSecondMin {
  public void dfs(TreeNode root, Queue<Integer> minHeap, Set<Integer> set) {
    if (root == null) return;
    
    if (!set.contains(root.val)) {
        minHeap.offer(root.val);
        set.add(root.val);
    }
    
    if (root.left != null) dfs(root.left, minHeap, set);
    if (root.right != null) dfs(root.right, minHeap, set);
    
    return;
    
}

  public int findSecondMinimumValue(TreeNode root) {
      Queue<Integer> minHeap = new PriorityQueue<>();
      Set<Integer> set = new HashSet<>();
      
      dfs(root, minHeap, set);
      minHeap.poll();
      
      if (minHeap.isEmpty()) return -1;
      return minHeap.poll();
  }
}
