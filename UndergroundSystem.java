import java.util.*;
class UndergroundSystem {

  Map<Integer, Pair<String, Integer>> customerCheckInMap;
  Map<String, List<Integer>> timeMap;
  
  public UndergroundSystem() {
      customerCheckInMap = new HashMap();
      timeMap = new HashMap();
  }
  
  public void checkIn(int id, String stationName, int t) {
      customerCheckInMap.put(id, new Pair<String, Integer> (stationName, t));
  }
  
  public void checkOut(int id, String stationName, int t) {
      if (customerCheckInMap.containsKey(id)) {
          int checkInTime = customerCheckInMap.get(id).getValue();
          List<Integer> list;
          if (timeMap.containsKey(customerCheckInMap.get(id).getKey()+"_"+stationName)) {
              list = timeMap.get(customerCheckInMap.get(id).getKey()+"_"+stationName);
          }
          else list = new ArrayList();
          
          list.add(t-checkInTime);
          timeMap.put(customerCheckInMap.get(id).getKey()+"_"+stationName, list);
      }
  }
  
  public double getAverageTime(String startStation, String endStation) {
      if (timeMap.containsKey(startStation+"_"+endStation)) {
          List<Integer> list = timeMap.get(startStation+"_"+endStation);
          double sum=0;
          for (int x : list) {
              sum+=x;
          }
          return sum / list.size();
      }
      
      return -1;
  }
}
