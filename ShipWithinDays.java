class ShipWithinDays {
  public boolean canShip(int[] weights, int cap, int days) {
    int temp = cap;
    for (int i=0; i<weights.length; i++) {
        
        if (days <= 0) return false;
        
        if (temp - weights[i] > 0) {
            temp -= weights[i];
        }
        else {
            if (temp - weights[i] < 0) i--;
            days--;
            temp = cap;
        }
    }
    
    return true;
}

public int shipWithinDays(int[] weights, int days) {
    int max =0;
    for (int weight : weights) {
        max = Math.max(weight, max);
    }
    
    int left = 0, right = Integer.MAX_VALUE;
    
    while (left<=right) {
        int mid = left + (right-left)/2;
        
        if (canShip(weights, mid, days)) {
            right = mid-1;
        }
        else {
            left = mid+1;
        }
    }
    
    return left;
}
}