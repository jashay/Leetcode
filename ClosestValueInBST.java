public class ClosestValueInBST {
  public int closestValue(TreeNode root, double target) {
    if (root == null) return -1;
    int val, closest = root.val;
    while (root != null) {
        val = root.val;
        closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
        root = root.val < target ? root.right : root.left;
    }
    return closest;
  }
}
