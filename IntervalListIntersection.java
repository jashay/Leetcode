import java.util.*;
class IntervalListIntersection {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int p1 = 0, p2 = 0;
    List<int[]> ans = new ArrayList<>();
    while (p1 < firstList.length && p2 < secondList.length) {
        int inStart = Math.max(firstList[p1][0], secondList[p2][0]);
        int inEnd = Math.min(firstList[p1][1], secondList[p2][1]);
        
        if (inEnd >= inStart) {
            ans.add(new int[]{inStart, inEnd});
        }
        
        if (firstList[p1][1] < secondList[p2][1]) {
            p1++;
        }
        else {
            p2++;
        }
    }
    
    return ans.toArray(new int[ans.size()][2]);
}
}