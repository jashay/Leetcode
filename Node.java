public class Node {
  Node left;
  Node right;
  Node next;
  int val;

  public Node(int v, Node l, Node r, Node next) {
    this.val = v;
    this.left = l;
    this.right = r;
    this.next = next;
  }
}
