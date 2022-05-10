public class MaxDistanceToClosest {
  public int maxDistToClosest(int[] seats) {
    int[] left = new int[seats.length];
    int[] right = new int[seats.length];
    int p = -1;
    
    for (int i=0; i<seats.length; i++) {
        if (seats[i] == 1) {
            left[i] = -1;
            p = i;
        }
        else {
            left[i] = p == -1 ? -1 : i - p;
        }
    }
    p = -1;
    for (int i=seats.length-1; i>=0; i--) {
        if (seats[i] == 1) {
            right[i] = -1;
            p = i;
        }
        else {
            right[i] = p == -1 ? -1 : p - i;
        }
    }
    int max = -1;
    for (int i=0; i<left.length; i++) {
        if (left[i] == -1 && right[i] == -1) continue;
        else if (right[i] == -1) max = Math.max(max, left[i]);
        else if (left[i] == -1) max = Math.max(max, right[i]);
        else max = Math.max(max, Math.min(left[i], right[i]));
    }
    return max;
  }
}
