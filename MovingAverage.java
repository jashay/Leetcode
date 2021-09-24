import java.util.*;
public class MovingAverage {
  List<Integer> q;
    int size;
    public MovingAverage(int size) {
        q = new ArrayList<>();
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        int sum=0;
        for (int i = Math.max(0, q.size() - size); i < q.size(); ++i) {
            sum += (int) q.get(i);
        }
        return sum*1.0/ Math.min(q.size(), size);
    }
}
