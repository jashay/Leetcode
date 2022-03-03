public class FirstBadVersion {

  public boolean isBadVersion(int x) {
    return false;
  }

  public int firstBadVersion(int n) {
    // Binary Search
    
    int left = 1;
    int right = n;
    
    while (left <= right) {
        int mid = left + (right-left)/2;
        
        if (isBadVersion(mid) && !isBadVersion(mid-1)) return mid;
        else if (!isBadVersion(mid) && isBadVersion(mid+1)) return mid+1;
        
        else if (isBadVersion(mid)) {
            // go left
            right = mid-1;
        }
        else {
            left = mid+1;
        }
    }
    
    return -1;
    
}
}
