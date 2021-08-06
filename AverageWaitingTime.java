import java.util.*;

public class AverageWaitingTime {
  public double averageWaitingTime(int[][] customers) {
    int[] waitTimes = new int[customers.length];
    List<int[]> q = new ArrayList<>();
    q.add(customers[0]);
    
    int currTime = customers[0][0];
    int index = 0;
    
    while (!q.isEmpty()) {
        int[] nextCustomer = q.remove(0);
        int arrivalTime = nextCustomer[0];
        currTime = Math.max(currTime, arrivalTime);
        int processingTime = nextCustomer[1];
        int finalTime = currTime+processingTime;
        waitTimes[index] = finalTime - arrivalTime;
        currTime = finalTime;
        if (customers.length - 1 > index)
            q.add(customers[++index]);
    }
    
    double sum=0;
    for (int time : waitTimes) {
        sum += time;
    }
    
    return 1.0 * sum / (waitTimes.length);
  }
}
