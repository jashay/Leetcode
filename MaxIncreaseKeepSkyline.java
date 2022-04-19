public class MaxIncreaseKeepSkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int n = grid.length;
    int[] maxRow = new int[n];
    int[] maxCol = new int[n];
    int[][] ans = new int[n][n];
    
    
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            maxRow[i] = Math.max(maxRow[i], grid[i][j]);
            maxCol[j] = Math.max(maxCol[j], grid[i][j]);
        }
    }

    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) { 
            ans[i][j] = Math.min(maxRow[i], maxCol[j]);
        }
    }
    int count =0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) { 
            count += ans[i][j] - grid[i][j];
        }
    }
    
    return count;
  }
}
