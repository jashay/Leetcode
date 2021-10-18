class TreeToDoublyLinkedList {
  Node head = null, tail = null;
    
  public void dfs(Node root) {
      if (root == null) return;
      
      dfs(root.left);
      if (tail == null) {
          head = root;
      }
      else {
          tail.right = root;
          root.left = tail;
      }
      tail = root;
      dfs(root.right);
  }
  
  
  public Node treeToDoublyList(Node root) {
      if (root == null) return null;
      
      dfs(root);
      
      head.left = tail;
      tail.right = head;
      
      return head;
  }
}