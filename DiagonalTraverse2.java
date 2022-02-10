import java.util.*;
public class DiagonalTraverse2 {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<Integer> list = new ArrayList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    
    for (int row = nums.size()-1; row >=0; row--) {
        for (int col = 0; col<nums.get(row).size(); col++) {
            map.putIfAbsent(row+col, new ArrayList<>());
            map.get(row+col).add(nums.get(row).get(col));
        }
    }
    
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        list.addAll(map.get(entry.getKey()));
    }
    
    int[] ans = new int[list.size()];
    
    for (int i=0; i<list.size(); i++) ans[i] = list.get(i);
    
    return ans;
}
}
