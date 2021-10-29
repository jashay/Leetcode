class InorderSuccesor2 {

  class Node {
    int val;
    Node parent;
    Node left;
    Node right;
  }

  public Node inorderSuccessor(Node node) {
    if (node.right == null) {
        //check parents
        Node parent = node.parent;
        while (parent != null && parent.val < node.val) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
    else {
        Node next = node.right;
        while (next.left != null) {
            next = next.left;
        }
        return next;
    }
}
}