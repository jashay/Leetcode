import java.util.*;
public class MaxKilledEnemies {
    Map<String, int[]> map = new HashMap<>();
    //left right up down
    public int[] killEnemies(char[][] grid, int i, int j) {
        int[] enemies = new int[4];
        // up 
        int x = i-1;
        int y = j;
        while (x>=0) {
            if (grid[x][y] == 'E') enemies[0]++;
            else if (grid[x][y] == 'W') break;
            x--;
        }
        
        x = i+1;
        y = j;
        //down
        while (x<grid.length) {
            if (grid[x][y] == 'E') enemies[1]++;
            else if (grid[x][y] == 'W') break;
            x++;
        }
        
        x = i;
        y = j-1;
        //left
        while (y>=0) {
            if (grid[x][y] == 'E') enemies[2]++;
            else if (grid[x][y] == 'W') break;
            y--;
        }
        
        x = i;
        y = j+1;
        //right
        while (y<grid[0].length) {
            if (grid[x][y] == 'E') enemies[3]++;
            else if (grid[x][y] == 'W') break;
            y++;
        }
        
        return enemies;
    }
    
    public int maxKilledEnemies(char[][] grid) {
        
        int max = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 'W' || grid[i][j] == 'E') continue;
                if (!map.containsKey(i+","+j)) {
                    map.put(i+","+j, killEnemies(grid, i, j));
                }
                int sum = 0;
                int[] arr = map.get(i+","+j);
                for (int x : arr) {
                    sum += x;
                }
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}
