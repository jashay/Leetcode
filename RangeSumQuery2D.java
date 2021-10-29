public class RangeSumQuery2D {
  int[][] matrix;
  int[][] preSum;
  public RangeSumQuery2D(int[][] matrix) {
      this.matrix = matrix;
      this.preSum = new int[matrix.length][matrix[0].length+1];
      
      for (int row = 0; row<matrix.length; row++) {
          for (int col = 0; col<matrix[0].length; col++) {
              preSum[row][col+1] = preSum[row][col] + matrix[row][col];
          }
      }
      
  }
  
  public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum =0;
      for (int row = row1; row <= row2; row++) {
          sum += preSum[row][col2+1] - preSum[row][col1];
      }
      
      return sum;
  }
}
