import java.util.*;
public class MyCalendar {
  List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] booking : list) {
            if (end> booking[0] && start<booking[1]) {
                return false;
            } 
        }
        
        list.add(new int[]{start,end});
        return true;
    }
}
