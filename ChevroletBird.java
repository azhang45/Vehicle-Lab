public class ChevroletBird extends ElectricCar implements Flying{

    private boolean wingsExtended;
    /** Chevrolet Birds have a 250 mile range on a full charge. They 
    start with their wings retracted.*/
    public ChevroletBird(double startingMileage) {
        super("Chevrolet", "Bird", startingMileage, 250);
        wingsExtended = false;
        
    }
    /** Defaults mileage to 0. */
    public ChevroletBird(){
        super("Chevrolet", "Bird", 250);
        wingsExtended = false;
    }

    /** Returns whether the wings are currently extended. */
    public boolean checkWingsExtended(){
        return wingsExtended;

    }
    /** Drives just like all other Electric Cars, except make sure that 
    you retract your wings first (duh).
    Coding tip: Write this method to re-use the behavior of the 
    superclass drive. Don’t copy-and-paste the same code here.*/
    public void drive(double miles){

        if (canDrive(miles)){
            wingsExtended = false;
            drive(miles);
        }

    }

    @Override
    public boolean canFly(double miles){
        if (miles < 0){
            throw new IllegalArgumentException("Miles cannot be negative");

        }
        if (miles > getRemainingRange()){
            throw new IllegalArgumentException("Miles exceeds the remaining range of the car.");
        }

        //driving/flying uses same amoutn of gas per mile
        return canDrive(miles);

    }

    @Override
    public void fly(double miles){
        if (canFly(miles)){
            wingsExtended = true;
        }
        
    }

}
