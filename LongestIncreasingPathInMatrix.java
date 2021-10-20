class LongestIncreasingPathInMatrix {
  int[][] dirs = {{0,1},{1,0}, {-1,0}, {0,-1}};
  public int dfs(int i, int j, int[][] matrix, int prev, int[][] cache) {        
    if (i<0 || j<0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) {
        return 0;
    }
   
    
    if (cache[i][j] != 0) {
        return cache[i][j];
    }
    int ans=0;
    for (int[] dir : dirs) {
        int newi = i + dir[0];
        int newj = j + dir[1];
        ans = Math.max(ans, dfs(newi, newj, matrix, matrix[i][j], cache));
    }
    cache[i][j] = ans;
    return ++cache[i][j];
}


public int longestIncreasingPath(int[][] matrix) {
    int max = 0;
    int[][] cache = new int[matrix.length][matrix[0].length];
    for (int i=0; i<matrix.length; i++) {
        for (int j=0; j<matrix[i].length; j++) {
            max = Math.max(max, dfs(i, j, matrix, -1, cache));
        }
    }
    
    return max;
}
}