public class FloodFill {
  public void dfs(int i, int j, int newColor, int[][] image, int oldColor) {
    if (i<0 || j<0 || i>=image.length || j>=image[0].length) {
        return;
    }
    
    if (newColor == oldColor) {
        return;
    }
    
    if (image[i][j] == oldColor) {
        image[i][j] = newColor;
        dfs(i-1, j, newColor, image, oldColor);
        dfs(i, j-1, newColor, image, oldColor);
        dfs(i, j+1, newColor, image, oldColor);
        dfs(i+1, j, newColor, image, oldColor);
    }
    
    return;
}


  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      
      
      dfs(sr,sc,newColor, image, image[sr][sc]);
      
      return image;
  }
}
