class MaxConsecuiveOnes2 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int end = 0, start = 0, max =0, count =0;
    
    for (; end< nums.length; end++) {
        while (count == 1 && nums[end] == 0) {
            if (nums[start] == 0) count--;
            
            start++;
        }
        max = Math.max(end-start+1, max);
        if (nums[end] == 0) count++;
    }
    
    return max;
}
}