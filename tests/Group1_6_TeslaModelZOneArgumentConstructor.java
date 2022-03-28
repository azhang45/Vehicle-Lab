package tests;

import vehicle.TeslaModelZ;

import java.util.ArrayList;
import java.util.Arrays;

import bcatest.BCATestScenario;

public class Group1_6_TeslaModelZOneArgumentConstructor extends BCATestScenario {
    public int runTest() {

        TeslaModelZ tesla = new TeslaModelZ(2);
        
        assertEquals(tesla.getMileage(), 0.0, 0.1, "Default mileage should be zero.");
        assertThrows(IllegalArgumentException.class, () -> {tesla.drive(-1);}, "Can't drive negative amount of miles");
        assertEquals((int) tesla.getRemainingRange(), 340, "Your Tesla should currently be at 340 miles of range");
        tesla.drive(0);
        assertEquals((int) tesla.getMileage(), 0, "Mileage should still be at 0");
        tesla.drive(40);
        assertEquals((int) tesla.getRemainingRange(), 300, "Your Tesla should currently be at 300 miles of range");
        assertThrows(IllegalArgumentException.class, () -> {tesla.drive(301);}, "Can't drive over the remaining ranger");
        tesla.drive(300);
        assertEquals((int) tesla.getRemainingRange(), 0, "Your Tesla should be empty");
        
        tesla.recharge();
        assertEquals((int) tesla.getRemainingRange(), 340, "Your Tesla should have been refilled");
        assertEquals(tesla.getModelNum(), 2, "Your Tesla should have a model number of 2");
        assertEquals(tesla.getModel(), "Z2", "Your Tesla should have Z2 as the model");
        assertEquals(tesla.toString(), "Tesla Z2 (340.0 mi)", "Tesla toString should be printing Tesla Z2 (340.0 mi)");
        assertEquals((int) tesla.getMileage(), 340, "Mileage should be 340");
        assertEquals(tesla.getMake(), "Tesla", "Make should be Tesla");

        ArrayList<Double> invalidRoadTrip = new ArrayList<>(Arrays.asList(0.0, -20.0, -50.0, 70.0));
        assertThrows(IllegalArgumentException.class, () -> {tesla.roadTrip(invalidRoadTrip);}, "For road trip, negative miles are not valid");
        assertEquals((int) tesla.getMileage(), 340, "Mileage should be 340");
        ArrayList<Double> validRoadTrip = new ArrayList<>(Arrays.asList(150.0, 100.0, 50.0, 70.0));
        assertEquals((int) tesla.roadTrip(validRoadTrip), 3, "3 days should have been driven");

        tesla.recharge();
        assertTrue(tesla.canDrive(0), "You have not moved but still supposed to be valid");
        assertThrows(IllegalArgumentException.class, () -> {tesla.canDrive(-1);}, "You cannot drive negative amount of miles");
        assertTrue(tesla.canDrive(340), "You should be able to drive a full tank");
        assertFalse(tesla.canDrive(341), "You cannot drive over the range");
        assertThrows(IllegalArgumentException.class, () -> {tesla.driveAutonomously(-100);}, "You cannot drive negative amount of miles");
        tesla.driveAutonomously(0);
        assertEquals((int)tesla.getMileage(),640, "Your mileage should still be 340");
        tesla.driveAutonomously(100);
        assertEquals((int)tesla.getMileage(), 740, "Your mileage should be 440");
        tesla.driveAutonomously(300);
        assertEquals((int)tesla.getMileage(), 980, "Your mileage should be 680");
        assertEquals((int)tesla.getMaxRange(), 340, "Your max range is 340 miles");


        return getFailedCount();
    }
}