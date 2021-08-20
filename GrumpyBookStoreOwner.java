public class GrumpyBookStoreOwner {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int maxAnswerWithoutPower = 0;
    for (int i=0; i<customers.length; i++) {
        maxAnswerWithoutPower += grumpy[i] == 0 ? customers[i] : 0;
    }    
    
    int maxCustomers = 0;
    for (int i=0; i<customers.length-minutes+1; i++) {
        int currentAnswer = maxAnswerWithoutPower;
        for (int j=i; j<i+minutes; j++) {
            currentAnswer += grumpy[j] == 1 ? customers[j] : 0;
        }
        maxCustomers = Math.max(maxCustomers, currentAnswer);
    }
    
    
    return maxCustomers;
  }
}
