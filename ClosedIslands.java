public class ClosedIslands {
  int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
  public boolean dfs(int[][] grid, int i, int j) {
      if (i<0 || j<0 || j >= grid[0].length || i >= grid.length) return false;
      
      if (grid[i][j] == 1) return true;
      
      grid[i][j] = 1;
      boolean res = true;
      for(int[] d : dir){
          res = res & dfs(grid, i + d[0], j + d[1]);
      }
      return res;
  }
  
  public int closedIsland(int[][] grid) {
      int count =0;
      for (int i=0; i<grid.length; i++) {
          for (int j=0; j<grid[0].length; j++) {
              if (grid[i][j] == 0) {
                  if (dfs(grid, i, j)) count++;
              }
          }
      }
      
      return count;
  }
}
