import java.util.*;
public class NumberOfRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        int ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                ans++;
                left++;
                right--;
            }
            else {
                right--;
                ans++;
            }
        }
        
        return ans;
    }
}
