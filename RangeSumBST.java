public class RangeSumBST {
  public void recurse(TreeNode root, int[] sum, int low, int high) {
        
    if (root == null) return;

    if (root.val >= low && root.val <= high) sum[0]+=root.val;;
    
    
    recurse(root.left, sum, low, high);
    recurse(root.right, sum, low, high);
    
}


  public int rangeSumBST(TreeNode root, int low, int high) {
      

      
      int[] sum = new int[1];
      sum[0] = 0;
      recurse(root, sum, low, high);
      
      return sum[0];
  }
}
