import java.util.*;
public class IslandPerimeter {
  public void dfs(int[][] grid, int i, int j, int[] peri, boolean[][] visited) {
    if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) {
        peri[0]++;
        return;
    }
    if (visited[i][j]) return;
    
    if (grid[i][j] == 0) {
        peri[0]++;
        return;
    }
    else {
        visited[i][j] = true;
        dfs(grid, i-1, j, peri, visited);
        dfs(grid, i+1, j, peri, visited);
        dfs(grid, i, j-1, peri, visited);
        dfs(grid, i, j+1, peri, visited);
    }
    return;
}

public int islandPerimeter(int[][] grid) {
    int[] peri = new int[1];
    
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    
    for (int i=0; i<visited.length; i++) {
        boolean[] b = new boolean[grid[0].length];
        Arrays.fill(b, false);
        visited[i] = b;
    }
    
    for (int i=0; i<grid.length; i++) {
        for (int j=0; j<grid[0].length; j++) {
            if (!visited[i][j]) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, peri, visited);
                    break;
                }
            }
            
        }
    }
    
    return peri[0];
}
}
