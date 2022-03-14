public abstract class GasPoweredCar extends Car {
    private double mpg;
    private double fuelCapacity;
    private double fuelLevel;

    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons) {
        super(make, model, startingMileage);
        if (mpg <= 0) {
            throw new IllegalArgumentException("MPG cannot be non-positive.");
        }
        if (fuelCapacityGallons <= 0) {
            throw new IllegalArgumentException("Max fuel capacity cannot be non-positive.");
        }
        this.mpg = mpg;
        this.fuelCapacity = fuelCapacityGallons;
        this.fuelLevel = fuelCapacityGallons;
    }

    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        super(make, model);
        if (mpg <= 0) {
            throw new IllegalArgumentException("MPG cannot be non-positive.");
        }
        if (fuelCapacityGallons <= 0) {
            throw new IllegalArgumentException("Max fuel capacity cannot be non-positive.");
        }
        this.mpg = mpg;
        this.fuelCapacity = fuelCapacityGallons;
        this.fuelLevel = fuelCapacityGallons;
    }

    public void drive(double miles) {
        if (miles <= 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be greater than 0.", miles));
        } else if (!canDrive(miles)) {

            throw new IllegalArgumentException(String.format("Cannot drive %.1f miles, the max you can go with current "
                    + "fuel is %.1f miles", miles, getRemainingRange()));
        }
        super.addMileage(miles);
        decreaseFuelLevel(miles);
    }

    public double getMPG() {
        return mpg;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void refillTank() {
        fuelLevel = fuelCapacity;
    }

    public double getRemainingRange() {
        return getFuelLevel() * getMPG();
    }

    public void refillTank(double gallons) {
        if (gallons < 0 || gallons + getFuelLevel() > getFuelCapacity()) {
            throw new IllegalArgumentException("Invalid number of gallons.");
        }

        fuelLevel += gallons;
    }

    public void decreaseFuelLevel(double miles) {
        fuelLevel -= miles / mpg;
    }
}
