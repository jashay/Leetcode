public class Search2DMatrix {
  public int getMatrixValue(int[][] matrix, int x) {
        
    int n = matrix[0].length;
    int row, col;
    if (x<n) {
        row = 0;
        col = x;
    }
    else {
        col = x%n;
        int c=0;
        while (x>=n) {
            x-=n;
            c++;
        }
        row = c;
    }
    
    return matrix[row][col];
    
}


public boolean searchMatrix(int[][] matrix, int target) {
    int start = 0;
    int m = matrix.length;
    if (m==0 ) return false;
    int n = matrix[0].length;
    int end = (m)*(n) -1;
    
    
    while (start<=end) {
        int mid = start + (end-start)/2;
        int val = getMatrixValue(matrix, mid);
        if (val == target) return true;
        else if (val < target) {
            start = mid+1;
        }
        else {
            end = mid-1;
        }
        
    }

    return false;
    
}
}
