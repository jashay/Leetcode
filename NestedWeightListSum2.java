import java.util.*;
public class NestedWeightListSum2 {
  // class Pair {
  //   int val;
  //   int depth;
  //   Pair(int v, int d) {
  //       this.val = v;
  //       this.depth = d;
  //   }
  // }

  // public void dfs(List<NestedInteger> nestedList, int currDepth, List<Pair> depth) {
  //   for (NestedInteger x : nestedList) {
  //       if (x.isInteger()) {
  //           depth.add(new Pair(x.getInteger(), currDepth));
  //       }
  //       else {
  //           dfs(x.getList(), currDepth+1, depth);
  //       }
  //   }
  // }

  // public int depthSumInverse(List<NestedInteger> nestedList) {
  //     int currDepth = 1;
  //     List<Pair> depthList = new ArrayList();
  //     dfs(nestedList, currDepth, depthList);
  //     int max = 0;
  //     for (Pair p : depthList) {
  //         max = Math.max(max, p.depth);
  //     }
  //     List<Integer> weights = new ArrayList();
  //     int ans = 0;
  //     for (Pair p : depthList) {
  //         weights.add(max - p.depth + 1);
  //     }
      
  //     for (int i=0; i<weights.size(); i++) {
  //         ans += depthList.get(i).val * weights.get(i);
  //     }
      
  //     return ans;
  // }
}
