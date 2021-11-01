class InsertIntoCircularLinkedList {
  class Node {
    int val;
    Node next;

    Node(int v) {
      this.val = v;
    }
    Node(int v, Node n) {
      this.val = v;
      this.next =n;
    }
  }
  public Node insert(Node head, int insertVal) {
    if (head == null) {
        Node t = new Node(insertVal);
        t.next = t;
        return t;
    }
    
    Node first = head;
    Node second = first.next;
    
    if (first == second) {
        Node t = new Node(insertVal);
        first.next = t;
        t.next = first;
        return head;
    }
    int count =0;
    while (count< 1000) {
        if (first.val <= insertVal && second.val >= insertVal) {
            Node t = new Node(insertVal);
            first.next = t;
            t.next = second;
            break;
        }
        else if (first.val > second.val) {
            if ((first.val > insertVal && second.val > insertVal) 
                || (first.val < insertVal && second.val < insertVal)) {
                Node t = new Node(insertVal);
                first.next = t;
                t.next = second;
                break;
            }
        }
        first = first.next;
        second = second.next;
        count++;
    }
    
    first.next = new Node(insertVal, second);
    return head;
}
}