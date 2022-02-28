import java.util.*;
public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> intervalList = Arrays.asList(intervals);
    List<int[]> l = new ArrayList<>(intervalList);
    List<int[]> ans = new ArrayList<>();
    l.add(new int[] {newInterval[0], newInterval[1]});
    
    Collections.sort(l, (a,b) -> a[0] - b[0]);
    
    // Merge
    int currFirst = l.get(0)[0];
    int currLast = l.get(0)[1];
    
    for (int[] interval : l) {
        if (currLast >= interval[0]) {
            currLast = Math.max(currLast, interval[1]);
        }
        else {
            ans.add(new int[] {currFirst, currLast});
            currFirst = interval[0];
            currLast = interval[1];
        }
    }
    
    ans.add(new int[] {currFirst, currLast});
    
    
    return ans.toArray(new int[ans.size()][2]);
}
}
