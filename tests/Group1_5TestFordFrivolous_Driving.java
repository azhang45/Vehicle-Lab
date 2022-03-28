package tests;

import java.util.ArrayList;
import java.util.Arrays;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group1_5TestFordFrivolous_Driving extends BCATestScenario {


    public int runTest() {
        assertThrows(IllegalArgumentException.class, () -> {new FordFrivolous(-100);}, "Starting mileage cannot be negative.");

        FordFrivolous f1 = new FordFrivolous();

        assertEquals(f1.getMileage(), 0, .1, "Starting mileage should be 0.0");

        assertEquals(f1.getFuelCapacity(), 20.0, .1, "Fuel capacity should be 20.0");

        assertEquals(f1.getFuelLevel(), 20.0, .1, "Fuel level should be 20.0");

        assertEquals(f1.getMPG(), 23.6, .1, "MPG should be 23.6");

        //f1.refillTank(15);
        assertThrows(IllegalArgumentException.class, () -> {f1.refillTank(-15);}, "Value to refill tank by cannot be negative");

        assertThrows(IllegalArgumentException.class, () -> {f1.drive(-10);}, "Driving mileage cannot be negative.");

        f1.drive(118);

        assertEquals(f1.getMileage(), 118.0, .1, "Mileage should be 118.0");

        assertEquals(f1.getFuelLevel(), 15.0, .1, "Fuel level should be 15.0");

        f1.refillTank();
        assertEquals(f1.getFuelLevel(), 20.0, .1, "Fuel level should be 20.0");

        assertThrows(IllegalArgumentException.class, () -> {f1.refillTank(100);}, "Amount to refill tank by cannot exceed tank capacity");

        assertEquals(f1.getRemainingRange(), 472.0, .1, "Remaining range should be 472.0");

        assertEquals(f1.toString(), "Ford Frivolous (118.0 mi)", "toString does not match");
        
        //TODO
        //Fix up roadtrip errors in car.java
        ArrayList<Double> roadTrip1 = new ArrayList<>();
        roadTrip1.addAll(Arrays.asList(50.0, 50.0, 50.0, -100.0));

        assertThrows(IllegalArgumentException.class, () -> {f1.roadTrip(roadTrip1);}, "Mileage in any position of the list cannot be negative");
        
        ArrayList<Double> roadTrip2 = new ArrayList<>();
        roadTrip2.addAll(Arrays.asList(100.0, 100.0, 100.0, 100.0, 24.8));

        f1.roadTrip(roadTrip2);
        assertEquals(f1.getMileage(), 542.8, .1, "Mileage should be 542.8");
        
        assertEquals(f1.getRemainingRange(), 47.2, .1, "Remaining range should be 47.2");

        f1.refillTank(8);
        assertEquals(f1.getFuelLevel(), 10, .1, "Fuel level should now be 10");

        ArrayList<Double> roadTrip3 = new ArrayList<>();
        roadTrip3.addAll(Arrays.asList(100.0, 100.0, 36.0));
        f1.roadTrip(roadTrip3);

        assertEquals(f1.getRemainingRange(), 0, .1, "Remaining range should be 0");

        f1.refillTank();

        assertEquals(f1.getMileage(), 778.8, .1, "Mileage should be 778.8");

        f1.fly(118);

        assertEquals(f1.getFuelLevel(), 5.0, .1, "Fuel level should 5.0" );

        assertEquals(f1.getMileage(), 778.8, .1, "Mileage should be 778.8");

        f1.refillTank();

        f1.driveAutonomously(118);

        assertEquals(f1.getFuelLevel(), 10.0, .1, "Fuel level should be 10.0");

        return getFailedCount();
    }
}
