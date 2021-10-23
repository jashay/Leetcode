class AngleBetweenClockHands {
  public double angleClock(int hour, int minutes) {
    
    double minuteAngle = minutes * 6;
    minuteAngle = minuteAngle == 360 ? 0 : minuteAngle;
    hour = hour == 12 ? 0 : hour;
    double hourAngle = hour*30 + ((minutes/60.0) * 30.0);
    
    double diff = Math.abs(minuteAngle - hourAngle);
    return Math.min(diff, 360 - diff);
  }
}