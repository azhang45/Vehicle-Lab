public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    
    public FordFrivolous(double startingMileage, int modelNumber) {
        super("Ford", "Frivolous", startingMileage, 340);
    }
    /** Defaults mileage to 0. */
    public FordFrivolous(){
    }

    @Override
    public void driveAutonomously(double miles) {
        if (miles <= 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be greater than 0.", miles));
        }
        if (miles > getRemainingRange()) {
            miles = getRemainingRange();
        }
        super.addMileage(miles);
        decreaseCharge(miles);
    }
    
    public void fly(double miles){

    }


      

}
