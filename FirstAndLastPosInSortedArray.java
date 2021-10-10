class FirstAndLastPosInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    int[] ans = new int[] {-1,-1};
    
    while (left <= right) {
        int mid = left + (right-left)/2;
        
        if (nums[mid] == target) {
            int i=mid, j=mid;
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            ans[0] = i+1;
            while (j < nums.length && nums[j] == target) {
                j++;
            }                
            ans[1] = j-1;
            break;
        }
        else if (nums[mid] < target) {
            left = mid + 1;
        }
        else if (nums[mid] > target) {
            right = mid-1;
        }
    }
    
    return ans;
}
}