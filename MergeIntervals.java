import java.util.*;
public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
        
    List<int[]> list = new ArrayList<>();
    
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    int currLast = intervals[0][1], currFirst = intervals[0][0];
    
    
    for (int i=1; i<intervals.length; i++) {
        int[] interval = intervals[i];
        if (interval[0] > currLast) {
            list.add(new int[]{currFirst, currLast});
            currFirst = interval[0];
            currLast = interval[1];
        }
        else {
            currLast = Math.max(currLast,interval[1]);
        }
        
        if (i==intervals.length-1) {
            list.add(new int[]{currFirst, currLast});
            break;
        }
    }
    
    int[][] ans = new int[list.size()][2];
    if (intervals.length == 1) {
        return new int[][]{new int[]{currFirst, currLast}};
    }
    for (int i=0; i<list.size(); i++) {
        ans[i] = list.get(i);
    }
    
    return ans;
}
}
