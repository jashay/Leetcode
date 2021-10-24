import java.util.*;
public class ShortestPathInBinaryMatrix {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap();
    Queue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
    List<Integer> list = new ArrayList();
    int start = 0, end = 0;
    for (; end<nums.length; end++) {
        count.put(nums[end], count.getOrDefault(nums[end], 0)+1);
        q.add(nums[end]);
        if (end - start + 1 == k) {
            while (count.containsKey(q.peek()) && count.get(q.peek()) == 0) {
                q.poll();
            }
            list.add(q.peek());
            count.put(nums[start], count.get(nums[start])-1);
            start++;
        }
    }
    int[] ans = new int[list.size()];
    for (int i=0; i<list.size(); i++) {
        ans[i] = list.get(i);
    }
    
    return ans;
}
}
