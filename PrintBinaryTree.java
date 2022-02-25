import java.util.*;
class PrintBinaryTree {
    
    class Pair {
        TreeNode node;
        int x;
        int y;
        
        Pair (TreeNode n, int x, int y) {
            this.node = n;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                
            }
            
            level++;
        }
        
        int cols = (int) Math.pow(2,level)-1;
        String[][] arr = new String[level][cols];
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, (int)(cols-1)/2));
        
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            arr[curr.x][curr.y] = String.valueOf(curr.node.val);
            
            if (curr.node.left != null) queue.add(new Pair(curr.node.left, curr.x+1, curr.y - (int) Math.pow(2, level-2-curr.x)));
            if (curr.node.right != null) queue.add(new Pair(curr.node.right, curr.x+1, curr.y + (int) Math.pow(2, level-2-curr.x)));
        }
        
        
        for (int i=0; i<level; i++) {
            List<String> temp = new ArrayList<>();
            for (int j=0; j<cols; j++) {
                temp.add(arr[i][j] == null ? "" : arr[i][j]);
            }
            ans.add(temp);
        }
        
        return ans;
        
    }
}