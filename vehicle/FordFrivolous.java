package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying {
    /**
     * FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6.
     */
    public FordFrivolous(double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    /**
     * Defaults mileage to 0.
     */
    public FordFrivolous() {
        super("Ford", "Frivolous", 23.6, 20);
    }

    /**
     * returns true if wings are retracted and the car has enough charge to go that
     * amount of miles
     */
    @Override
    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be at least 0.", miles));
        }
        return getRemainingRange() / 3 >= miles;
    }

    @Override
    public void fly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be at least 0. ", miles));
        }
        if (!canFly(miles)) {
            throw new IllegalArgumentException(String.format("Cannot fly %.1f miles, max you can fly with your fuel " +
                    "is %.1f miles", miles, (getFuelLevel() * (getMPG() / 3))));
        }
        decreaseFuelLevel((miles * 3));
    }

    @Override
    public void driveAutonomously(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be at least 0.", miles));
        }
        if (miles > getRemainingRange() / 2) {
            miles = getRemainingRange() / 2;
        }
        addMileage(miles);
        decreaseFuelLevel((miles * 2));
    }
}