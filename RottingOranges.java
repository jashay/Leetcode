import java.util.*;
public class RottingOranges {
  public int orangesRotting(int[][] grid) {
    Queue<int[]> q = new LinkedList<>();
    int count=0;
    for (int i=0; i<grid.length; i++) {
        for (int j=0; j<grid[0].length; j++) {
            if (grid[i][j] == 2) q.add(new int[]{i, j});
            else if (grid[i][j] == 1) count++;
        }
    }
    int minutes = -1;
    if(count == 0) return 0;
    while (!q.isEmpty()) {
        int size = q.size();
        minutes++;
        for (int i=0; i<size; i++) {
            
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            if (x-1 >=0 && grid[x-1][y] ==1) {
                grid[x-1][y] = 2;
                q.add(new int[] {x-1, y});
                count--;
            }
            if (x+1<grid.length && grid[x+1][y] ==1) {
                grid[x+1][y] = 2;
                q.add(new int[] {x+1, y});
                count--;
            }
            if (y-1 >=0 && grid[x][y-1] ==1) {
                grid[x][y-1] = 2;
                q.add(new int[] {x, y-1});
                count--;
            }
            if (y+1 < grid[0].length && grid[x][y+1] ==1) {
                grid[x][y+1] = 2;
                q.add(new int[] {x, y+1});
                count--;
            }
        }
    }
    
    return count==0 ? minutes : -1;
}
}
