import java.util.*;
public class NestedWeightListSum {
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

  // public int depthSum(List<NestedInteger> nestedList) {
  //     List<Pair> depthList = new ArrayList();
  //     dfs(nestedList, 1, depthList);
  //     int ans = 0;
  //     for (Pair p : depthList) {
  //         ans += p.depth*p.val;
  //     }
  //     return ans;
  // }
}
