import java.util.*;
public class FindNearestFood {
  public int getFood(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[] pos = new int[2];
    for (int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++) {
            if (grid[i][j] == '*') {
                pos = new int[]{i,j};
            }
        }
    }
    
    Queue<int[]> q = new LinkedList<>();
    q.add(pos);
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int level = 0;
    Set<String> visited = new HashSet<>();
    while (!q.isEmpty()) {
        int size = q.size();
        for (int i=0; i<size; i++) {
            int[] curr = q.poll();
            if (grid[curr[0]][curr[1]] == '#') {
                return level;
            }
            for (int[] d : dirs) {
                int nexti=curr[0]+d[0];
                int nextj=curr[1]+d[1];
                
                if (nexti<0 || nextj < 0 || nexti>=rows || nextj >=cols || visited.contains(nexti+","+nextj) || grid[nexti][nextj] == 'X') {
                    continue;
                }
                
                visited.add(nexti+"," + nextj);
                q.add(new int[]{nexti,nextj});
            }
        }
        level++;
    }
    
    return -1;
}
}
