public class MissingNumber {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int currSum = n *(n+1)/2;
    
    for (int num : nums) {
        currSum -= num;
    }
    
    return currSum;
    
  } 
}
