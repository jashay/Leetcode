import java.util.*;
class MaxSumOfLevels {
  public int maxLevelSum(TreeNode root) {
    Queue<TreeNode> q = new LinkedList();
    q.add(root);
    List<Integer> list = new ArrayList();
    while (!q.isEmpty()) {
        int size = q.size();
        int sum = 0;
        for (int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            sum+=curr.val;
            if (curr.left!=null) q.add(curr.left);
            if (curr.right!=null) q.add(curr.right);
        }
        list.add(sum);
    }
    int index = 0;
    int max = Integer.MIN_VALUE;        
    for (int i=0; i<list.size(); i++) {
        if (max < list.get(i)) {
            index =i;
            max = list.get(i);
        }
    }
    return index+1;
}
}