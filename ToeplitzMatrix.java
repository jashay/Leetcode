public class ToeplitzMatrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    for (int col=0; col<cols; col++) {
        int first = matrix[0][col];
        int row = 0;
        int j = col;
        while (row <rows && j<cols) {
            if (matrix[row][j] != first) {
                return false;
            }
            row++;
            j++;
        }
    }
    
    for (int row = 1; row<rows; row++) {
        int first = matrix[row][0];
        int col = 0;
        int i = row;
        while(col<cols && i<rows) {
            if (matrix[i][col] != first) return false;
            col++;
            i++;
        }
    }
    
    return true;
}
}
