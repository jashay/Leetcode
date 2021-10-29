public class LargestSubarrayLengthK {
  public int[] largestSubarray(int[] nums, int k) {
    int[] ans = new int[k];
    int max = 0, index =0;
    for (int i=0; i<=nums.length-k; i++) {
        if (max < nums[i]) {
            max = nums[i];
            index=i;
        }
    }

    for (int x =index; x<index+k; x++) {
        ans[x-index] = nums[x];
    }
    
    return ans;
  }
}
