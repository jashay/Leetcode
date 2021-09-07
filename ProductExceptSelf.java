class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] leftProd = new int[nums.length];
    int[] rightProd = new int[nums.length];
    int prod = 1;
    for (int i=0; i<nums.length; i++) {
        if (i==0) {
            leftProd[i] = 1;
        }
        else {
            leftProd[i] = prod;
        }
        prod *= nums[i];
    }
    prod = 1;
    for (int i=nums.length-1; i>=0; i--) {
        if (i==nums.length-1) rightProd[i] = 1;
        else {
            rightProd[i] = prod;
        }
        prod *= nums[i];
    }
    
    int[] ans = new int[nums.length];
    
    for (int i=0; i<nums.length; i++) {
        ans[i] = leftProd[i] * rightProd[i];
    }
    return ans;
  }
}