class MinIncrementForUnique {
	public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
    
        int count = 0, req=0;
        for (int x : nums) {
            count += Math.max(req - x, 0);
            req = Math.max(req, x) + 1;
        }
        
        return count;
    }
}
