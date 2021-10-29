public class MaxConsecutiveOnes3 {
  public int longestOnes(int[] nums, int k) {
    // Sliding Window
    
    int end = 0, start =0;
    int max = 0;
    int count =0;
    for (; end<nums.length; end++) {
        while (count >= k && nums[end] == 0) {
            if (nums[start] == 0) {
                count--;
            }
            start++;
        }
        if (nums[end] == 0) {
            count++;
        }
        max = Math.max(end-start+1, max);
    }
    
    return max;
  }
}
