import java.util.*;
public class NUniqueIntegersSumToZero {
    public int[] sumZero(int n) {
        Random rand=new Random();
        int[] ans = new int[n];
        int i=0;
        
        if (n%2 != 0) {
            ans[i] = 0;
            i++;
        }
        
        while (i < n && i+1 < n) {
            int num = rand.nextInt();
            ans[i++] = num;
            ans[i++] = num * -1;
        }
        return ans;
    }
}
