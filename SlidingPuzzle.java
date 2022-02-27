import java.util.*;
public class SlidingPuzzle {
    public String getString(int[][] board) {
        String ans = "";
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                ans += board[i][j] + ",";
            }
        }
        
        return ans;
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int slidingPuzzle(int[][] board) {
        Queue<int[][]> q= new LinkedList<>();
        q.add(board);
        
        int[][] temp = {{1,2,3},{4,5,0}};
        String ans = getString(temp);
            
        Set<String> visited = new HashSet<>();
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[][] curr = q.poll();
                int a = 0, b =0;
                visited.add(getString(curr));
                if (getString(curr).equals(ans)) return level;
                
                for (int x=0; x<curr.length; x++) {
                    for (int y=0; y<curr[0].length; y++) {
                        if (curr[x][y] == 0) {
                            a=x;
                            b=y;
                            break;
                        }
                    }
                }
                
                for (int[] dir : dirs) {
                    int newa = a + dir[0];
                    int newb = b + dir[1];
                    
                    if (newa < 0 || newb < 0 || newa >= curr.length || newb >= curr[0].length) continue;
                    
                    int[][] newboard = {{curr[0][0],curr[0][1],curr[0][2]}, {curr[1][0], curr[1][1], curr[1][2]}};
                    
                    newboard[newa][newb] = curr[a][b];
                    newboard[a][b] = curr[newa][newb];
                    
                    if (visited.contains(getString(newboard))) continue;
                    
                    q.add(newboard);
                }
                
            }
            level++;
        }
        
        return -1;
    }
}
