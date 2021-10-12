import java.util.*;
class SparseVector {
    
  Set<Integer> nonZeroIndexes = new HashSet();
  int[] nums;
  SparseVector(int[] nums) {
      for (int i=0; i<nums.length; i++) {
          if (nums[i] != 0) nonZeroIndexes.add(i);
      }
      this.nums=nums;
  }
  
// Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
      int ans = 0;
      for (int i : vec.nonZeroIndexes) {
          if (this.nonZeroIndexes.contains(i)) ans += this.nums[i]*vec.nums[i];
      }
      return ans;
  }
}