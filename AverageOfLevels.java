import java.util.*;
public class AverageOfLevels {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> list = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    
    while (!q.isEmpty()) {
        double size = q.size();
        double sum = 0.0;
        for (int i=0; i< size; i++) {
            TreeNode c = q.poll();
            sum += c.val;
            if (c.left != null) q.add(c.left);
            if (c.right != null) q.add(c.right);
        }
        
        list.add(sum/size);
    }
    
    
    return list;
}
}
