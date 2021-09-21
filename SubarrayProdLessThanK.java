class SubarrayProdLessThanK {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int ans = 0;
    int end = 0, start = 0;
    if (k<=1) return 0;
    int prod = 1;
    for (end = 0; end<nums.length; end++) {
        prod *= nums[end];
        while (prod >= k) {
            prod /= nums[start++];
        }
        ans += end - start + 1;
    }
    return ans;
  }
}