import java.util.*;
public class TopKFrequentElements {
  private class Pair {
    int index;
    int count;
    
    Pair(int index, int count) {
        this.index = index;
        this.count = count;
    }
}

 
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Pair> map = new HashMap<>();
    
    for (int num : nums) {
        if (map.containsKey(num)) {
            Pair temp = map.get(num);
            temp.count += 1;
        }
        else {
            map.put(num,new Pair(num, 1));
        }
    }
    
    List<Pair> list = new ArrayList<>();
    
    for (int key : map.keySet()) {
        list.add(map.get(key));
    }
    
    Collections.sort(list, (a,b) -> b.count - a.count);
    int[] ans = new int[k];
    for (int i=0; i<k;i++) {
        ans[i] = list.get(i).index;
    }
    
    return ans;
    
  } 
}
