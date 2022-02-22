import java.util.*;
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i=0; i<rows; i++) {
            rowMap.putIfAbsent(i, new HashSet<>());
            for (int j=0; j<cols; j++) {
                if (board[i][j] == '.') continue;
                if (rowMap.get(i).contains(board[i][j])) return false;       
                rowMap.get(i).add(board[i][j]);
            }
        }
        
        for (int i=0; i<cols; i++) {
            colMap.putIfAbsent(i, new HashSet<>());
            for (int j=0; j<rows; j++) {
                if (board[j][i] == '.') continue;
                if (colMap.get(i).contains(board[j][i])) return false;       
                colMap.get(i).add(board[j][i]);
            }
        }
        
        for (int i=0; i<=6; i+=3) {
            for (int j=0; j<=6; j+=3) {
                // start points
                Set<Character> set = new HashSet<>();
                for (int x=i; x<i+3; x++) {
                    for (int y=j; y<j+3; y++) {
                        if (board[x][y] == '.') continue;
                        if (set.contains(board[x][y])) return false;
                        set.add(board[x][y]);
                    }
                }
            }
        }
        
        return true;
    }
}
