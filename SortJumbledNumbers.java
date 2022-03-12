import java.util.*;
public class SortJumbledNumbers {
    class Pair {
        int original;
        int val;
        int index;
        Pair(int o, int v, int i) {
            this.original = o;
            this.val = v;
            this.index = i;
        }
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] sortednums = new int[nums.length];
        List<Pair> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            String s = String.valueOf(nums[i]);
            String newS = "";
            for (char c : s.toCharArray()) {
                int d = Character.getNumericValue(c);
                newS += mapping[d];
            }
            list.add(new Pair(nums[i], Integer.parseInt(newS), i));
        }
        
        Collections.sort(list, (a,b) -> a.val == b.val ? a.index - b.index : a.val - b.val);
        
        for (int i=0; i<sortednums.length; i++) sortednums[i] = list.get(i).original;
        
        return sortednums;
    }
}
