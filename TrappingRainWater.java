public class TrappingRainWater {
  public int trap(int[] height) {
    int[] maxLeft = new int[height.length];
    int[] maxRight = new int[height.length];
    
    for (int i=1; i<height.length; i++) {
        maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
    }
    
    for (int i=height.length-2; i>=0; i--) {
        maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
    }
    
    int ans = 0;
    for (int i=0; i<height.length; i++) {
        if (Math.min(maxLeft[i],maxRight[i]) - height[i] <= 0) continue;
        else ans += Math.min(maxLeft[i],maxRight[i]) - height[i] ;
    }
    
    return ans;
    
}
}
