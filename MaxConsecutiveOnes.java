public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;
    int curr = 0;
    for (int n :nums) {
        if (n==1) {
            curr++;
        }
        else {
            maxCount = Math.max(curr, maxCount);
            curr = 0;
        }
    }
    
    maxCount = Math.max(curr, maxCount);
    
    return maxCount;
}
}
