class PrefixSumWithWeight {
  int[] prefixSums;
  int totalSum = 0;
  public PrefixSumWithWeight(int[] w) {
      prefixSums = new int[w.length];
      for (int i=0; i<w.length; i++) {
          prefixSums[i] = totalSum + w[i];
          totalSum += w[i];
      }
  }
    
  public int pickIndex() {
      double target = totalSum * Math.random();
      int left = 0, right = prefixSums.length-1; 
      
      while (left <= right) {
          int mid = (left+right)/2;
          if (target < prefixSums[mid]) {
              right = mid-1;
          }
          else 
              left = mid +1;
      }
      
      return left;
  }
}