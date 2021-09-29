class SearchInRotatedSortedArray {
  public int findMin(int[] nums) {
        
    int left = 0;
    int right = nums.length-1;
    int mid=0;
    
    
    if (nums.length == 1) {
         return nums[0];
    }
    if (nums[right] > nums[0]) {
         return nums[0];
    }
    while (left <= right) {
         mid = left + (right-left)/2;
        
        if (mid +1 < nums.length && nums[mid] > nums[mid+1]) {
            return nums[mid+1];
        }
        
        if (mid -1 >= 0 && nums[mid] < nums[mid-1]) {
            return nums[mid];
        }
        if (nums[mid] > nums[0]) left = mid+1;
        else right = mid-1;
    }

    return nums[mid];
}
}