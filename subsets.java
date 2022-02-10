import java.util.*;
public class Subsets {

    public void recursivePut(int[] nums, int i, Set<String> set, String curr) {
        
        set.add(curr);
        
        if (i >= nums.length) return;
        
        if (!set.contains(curr+nums[i])) recursivePut(nums, i+1, set, curr+nums[i]+",");
        recursivePut(nums, i+1, set, curr);
    }

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    if (nums.length == 0) return ans;
    
    Set<String> set = new HashSet<>();
    
    recursivePut(nums, 0, set, "");
    
    for (String x : set) {
        if (!x.equals("")) {
            String[] array = x.split(",");
            List<Integer> list = new ArrayList<>();
            for (String str : array) {
                list.add(Integer.parseInt(str));
            }
            ans.add(list);
        }
    }
    
    return ans;
}
}
