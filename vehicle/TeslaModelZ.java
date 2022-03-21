package vehicle;

public class TeslaModelZ extends ElectricCar implements SelfDriving {
    protected int modelNum;

    public TeslaModelZ(double startingMileage, int modelNumber) {
        super("Tesla", "Z", startingMileage, 340);
        this.modelNum = modelNumber;
    }

    public TeslaModelZ(int modelNumber) {
        super("Tesla", "Z", 340);
        this.modelNum = modelNumber;
    }

    public int getModelNum() {
        return modelNum;
    }

    @Override
    public String getModel() {
        return String.format("%s%d", super.getModel(), modelNum);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%.1f mi)", getMake(), getModel(), getMileage());
    }

    @Override
    public void driveAutonomously(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be non-negative.", miles));
        }
        if (miles > getRemainingRange()) {
            miles = getRemainingRange();
        }
        super.addMileage(miles);
        decreaseCharge(miles);
    }
}