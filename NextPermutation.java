class NextPermutation {
  public void reverse(int[] nums, int start) {
    int left = start, right = nums.length-1;
    while (left<right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
}


public void nextPermutation(int[] nums) {
    int index = -1;
    for (int i=nums.length-1; i>0 ; i--) {
        if (nums[i-1] < nums[i]) {
            index = i-1;
            break;
        }
    }
    
    if (index == -1) {
        reverse(nums, 0);
        return;
    }
    int j=nums.length-1;
    for (; j>=index+1; j--) {
        if (nums[j]> nums[index]) {
            break;
        }
        
    }
    int temp = nums[index];
    nums[index] = nums[j];
    nums[j] = temp;    
    reverse(nums, index+1);
    
    return;
}
}