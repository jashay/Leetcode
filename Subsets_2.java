public class Subsets_2 {
  public void recursivePut(int[] nums, int i, List<List<Integer>> list, List<Integer> curr) {
        
    list.add(new ArrayList<>(curr));

    for (int x=i; x<nums.length; x++) {
        if (x>i && nums[x]==nums[x-1]) continue;
        curr.add(nums[x]);
        recursivePut(nums, x+1, list, curr);
        curr.remove(curr.size()-1);
    }
}

  public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();


      recursivePut(nums, 0, ans, new ArrayList<>());

      return ans;
  }
}
