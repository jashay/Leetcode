import java.util.*;

public class NextGreaterElement {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
    Map<Integer, Integer> map = new HashMap<>(); // Map of <value,index>
    int[] ans = new int[nums1.length];
    
    for (int i=0; i<nums2.length; i++) {
        map.put(nums2[i], i);
    }
    
    for (int j=0; j<nums1.length; j++) {
        int index = map.get(nums1[j]);
        ans[j]=-1;
        for (int x=index; x<nums2.length; x++) {
            if (nums1[j] < nums2[x]) {
                ans[j] = nums2[x];
                break;
            }
        }
    }
    
    return ans;
  }
}
