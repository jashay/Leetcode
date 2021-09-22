public class GetMaxGold {
  int max = 0;
    
    public void dfs(int[][] grid, int i, int j, int curr, int[][] visited) {
        if (i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0) {
            max = Math.max(curr, max);
            return;
        }
        
        visited[i][j] = 1;
        dfs(grid, i-1, j, curr+grid[i][j], visited);
        dfs(grid, i+1, j, curr+grid[i][j], visited);
        dfs(grid, i, j-1, curr+grid[i][j], visited);
        dfs(grid, i, j+1, curr+grid[i][j], visited);
        visited[i][j] = 0;
    }
    
    
    public int getMaximumGold(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0, visited);
                }
            }
        }
        
        return max;
    }
}
