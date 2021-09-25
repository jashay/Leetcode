public class WhereWillTheBallFall {
  public int dfs(int[][] grid, int i, int j) {
    if (j<0 || j>=grid[0].length) return -1;
    
    if (i==grid.length) {
        return j;
    }
    
    if (grid[i][j] == 1) {
        if (j+1 == grid[0].length || grid[i][j+1] == -1) {
            return -1;
        }
        else {
            return dfs(grid, i+1, j+1);
        }
    }
    else {
        if (j-1 < 0 || grid[i][j-1] == 1) {
            return -1;
        }
        else {
            return dfs(grid, i+1, j-1);
        }
    }
    
}


  public int[] findBall(int[][] grid) {
      int[] ball = new int[grid[0].length];
      
      for (int j=0; j<ball.length; j++) {
          ball[j] = dfs(grid, 0, j);
      }
      
      return ball;
  }
}
