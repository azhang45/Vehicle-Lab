package vehicle;

public abstract class ElectricCar extends Car {
    private final double maxRange;
    private double range;

    protected ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        super(make, model, startingMileage);
        if (milesOnMaxCharge <= 0) {
            throw new IllegalArgumentException(String.format("Miles on max charge %.1f must be greater than 0.", milesOnMaxCharge));
        }
        this.maxRange = milesOnMaxCharge;
        this.range = milesOnMaxCharge;
    }

    protected ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make, model);
        if (milesOnMaxCharge <= 0) {
            throw new IllegalArgumentException(String.format("Miles on max charge %.1f must be greater than 0.", milesOnMaxCharge));
        }
        this.maxRange = milesOnMaxCharge;
        this.range = milesOnMaxCharge;
    }

    public void drive(double miles) {
        if (miles <= 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be greater than 0.", miles));
        } else if (!canDrive(miles)) {

            throw new IllegalArgumentException(String.format("Cannot drive %.1f miles, the max you can go with current " + " charge is %.1f miles", miles, getRemainingRange()));
        }
        super.addMileage(miles);
        decreaseCharge(miles);
    }

    public double getRemainingRange() {
        return range;
    }


    public double getMaxRange() {
        return maxRange;

    }

    public void recharge() {
        range = maxRange;
    }

    protected void decreaseCharge(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be greater than 0.", miles));
        } else if (miles > getRemainingRange()) {
            throw new IllegalArgumentException(String.format("Cannot remove %.1f miles from the charge " " while the capacity is at %.1f.", miles, getRemainingRange()));
        }
        range -= miles;
    }
}