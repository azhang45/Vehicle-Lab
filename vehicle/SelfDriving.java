package vehicle;

public interface SelfDriving {
    /**
     * @throws IllegalArgumentException if miles is negative.
     */
    void driveAutonomously(double miles);
}