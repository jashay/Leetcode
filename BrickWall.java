import java.util.*;
public class BrickWall {
  public int leastBricks(List<List<Integer>> wall) {
    int sum = 0;
    for (int x : wall.get(0)) {
        sum+=x;
    }
    
    Map<Integer, Integer> map = new HashMap<>();
    
    for (List<Integer> list : wall) {
        int currSum = 0;
        for (int i=0; i<list.size(); i++) {
            currSum += list.get(i);
            if (currSum == sum) break;
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
    }
    int max = 0;
    for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        int v = entry.getValue();
        max = Math.max(max, v);
    }
    
    return wall.size()-max;
}
}
