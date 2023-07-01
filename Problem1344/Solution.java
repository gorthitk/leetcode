class Solution {
    public double angleClock(int hour, int minutes) {
        int oneMinuteAngle = 360 / 60;
        int oneHourAngle = 360 / 12;

        double minAngle = minutes * oneMinuteAngle;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

        double diff = Math.abs(hourAngle - minAngle);

        return Math.min(diff, 360 - diff);
    }
}