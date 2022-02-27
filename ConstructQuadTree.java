public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
    
        
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
    }
    public boolean checkLeaf(int[][] grid, int[] topLeft, int[] bottomRight, int val) {
        for (int i=topLeft[0]; i<=bottomRight[0]; i++) {
            for (int j=topLeft[1]; j<=bottomRight[1]; j++) {
                if (grid[i][j] != val) return false;
            }
        }
        return true;
    }
    
    public Node dfs(int[] topLeft, int[] bottomRight, int[][] grid) {
        Node node = new Node();
        
        if (checkLeaf(grid, topLeft, bottomRight, grid[topLeft[0]][topLeft[1]])) {
            node.isLeaf = true;
            node.val = grid[topLeft[0]][topLeft[1]] == 1;
            return node;
        }
        
        // recursion
        else {
            node.isLeaf = false;
            node.val = true;
            int rowMid = (topLeft[0] + bottomRight[0]) / 2, colMid = (topLeft[1] + bottomRight[1]) / 2;
            node.topLeft = dfs(new int[]{topLeft[0], topLeft[1]}, new int[]{rowMid, colMid}, grid);
            
            node.topRight = dfs(new int[]{topLeft[0], colMid + 1}, new int[]{rowMid, bottomRight[1]}, grid);
            
            node.bottomLeft = dfs(new int[]{rowMid + 1, topLeft[1]}, new int[]{bottomRight[0], colMid}, grid);
            
            node.bottomRight = dfs(new int[]{rowMid + 1, colMid + 1}, new int[]{bottomRight[0], bottomRight[1]}, grid);

            return node;
        }
    }
    
    public Node construct(int[][] grid) {
        int n = grid.length;
    
        return dfs(new int[]{0,0}, new int[]{n-1,n-1}, grid);
    }
}
