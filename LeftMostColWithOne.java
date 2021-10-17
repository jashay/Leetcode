import java.util.*;
class LeftMostColWithOne {

  class BinaryMatrix {
    public int get(int i, int j) {
      return 0;
    }
    public List<Integer> dimensions() {
      return new ArrayList<>();
    }
  }

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dimensions = binaryMatrix.dimensions();
    
    int m = dimensions.get(0);
    int n = dimensions.get(1);
    int i = m-1,j=n-1;
    int min=-1;
    while (i>=0 && j>=0) {
        // keep checking left
        if (binaryMatrix.get(i,j) == 1) {
            min = j;
            j--;
            continue;
        }
        else {
            i--;  
        }
    }
    
    return min;
    
}
}