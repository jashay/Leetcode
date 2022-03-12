import java.util.*;
public class VerticalOrderTraversalBinaryTree {
  class Triplet {
    int row, col;
    TreeNode node;
    
    public Triplet(TreeNode n, int r, int c) {
        this.node = n;
        this.row = r;
        this.col = c;
    }
}


public List<List<Integer>> verticalTraversal(TreeNode root) {
    Queue<Triplet> q =new LinkedList<>();
    q.add(new Triplet(root, 0 ,0));
    List<Triplet> list = new ArrayList<>();
    while (!q.isEmpty()) {
        Triplet curr = q.poll();
        list.add(curr);
        if (curr.node.left != null) q.add(new Triplet(curr.node.left, curr.row+1, curr.col -1));
        if (curr.node.right != null) q.add(new Triplet(curr.node.right, curr.row+1, curr.col +1));
    }
    
    Collections.sort(list, (a,b) -> a.col - b.col);
    List<List<Triplet>> fin = new ArrayList<>();
    List<Triplet> temp = new ArrayList<>();
    temp.add(list.get(0));
    int currCol = list.get(0).col;
    for (int i=1; i<list.size(); i++) {
                   
        if (list.get(i).col == currCol) {
            temp.add(list.get(i));
        }
        else {
            Collections.sort(temp, new Comparator<Triplet>() {
                public int compare(Triplet a, Triplet b) {
                    if (a.row == b.row) {
                        return a.node.val - b.node.val;
                    }
                    else {
                        return a.row - b.row;
                    }   
                }
            });
        
            fin.add(temp);
            temp = new ArrayList<>();
            temp.add(list.get(i));
            currCol = list.get(i).col;
        }
    }
    Collections.sort(temp, new Comparator<Triplet>() {
        public int compare(Triplet a, Triplet b) {
            if (a.row == b.row) {
                return a.node.val - b.node.val;
            }
            else {
                return a.row - b.row;
            }   
        }
    });
    fin.add(temp);
    
    List<List<Integer>> ans = new ArrayList<>();
    for (List<Triplet> col : fin) {
        List<Integer> t = new ArrayList<>();
        for (int i=0; i<col.size(); i++) {
            t.add(col.get(i).node.val);
        }
        ans.add(t);
    }
    
    return ans;
    
}
}
