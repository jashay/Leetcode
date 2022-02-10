import java.util.*;
class MakingALargeIsland {
  public int dfs(int[][] grid, int i, int j, int index) {
    if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || grid[i][j] >1) return 0;
    
    grid[i][j] = index;
    
    return 1 + dfs(grid, i+1, j, index)
    + dfs(grid, i-1, j, index)
    + dfs(grid, i, j+1, index)
    + dfs(grid, i, j-1, index);
}


public int largestIsland(int[][] grid) {
    int max = 0, index = 3;
    int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    Map<Integer, Integer> map = new HashMap<>();
    for (int i=0; i<grid.length; i++) {
        for (int j =0; j<grid[0].length; j++) {
            if (grid[i][j] == 1) {
                map.put(index, dfs(grid, i, j, index));
                max = Math.max(max, map.get(index++));
            }
        }
    }
    for (int i=0; i<grid.length; i++) {
        for (int j =0; j<grid[0].length; j++) {
            if (grid[i][j] == 0) {
                int total = 1;
                Set<Integer> visited= new HashSet<>();
                for (int[] move : moves) {
                    if (i+move[0] >= 0 && move[0]+i<grid.length 
                        && j+move[1] >= 0 && move[1]+j<grid[0].length 
                        && grid[i+move[0]][j+move[1]] > 1 && !visited.contains(grid[i+move[0]][j+move[1]])) {
                        total += map.get(grid[i+move[0]][j+move[1]]);
                        visited.add(grid[i+move[0]][j+move[1]]);
                    }
                    max = Math.max(total, max);
                }
            }
        }
    }
    return max;
}
}