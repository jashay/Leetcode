public class InsertIntoBST {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode curr = root;

    if (curr == null) return new TreeNode(val);
    
    while(true){
        if(val <= curr.val){
            if(curr.left != null){
                curr = curr.left;
            }
            else {
                curr.left = new TreeNode(val);
                break;
            }
        }
        if(val >= curr.val){
            if(curr.right != null){
                curr = curr.right;
            }
            else {
                curr.right = new TreeNode(val);
                break;
            }
        }
    }
    return root;
  }
}
