package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;
import java.util.*;

public class Group3_2TeslaDriver extends BCATestScenario {
    public int runTest() {

        // tesla recharge and drive test
        TeslaModelZ tz = new TeslaModelZ(5, 2341);

        tz.recharge();
        assertEquals(tz.getRemainingRange(), 340.0, 0.0001, "After recharging, tesla range should be back to 340");
        tz.drive(45);
        assertEquals(tz.getRemainingRange(), 340.0 - 45.0, 0.001,
                "After driving 45 miles, the remaining range should be 340-45 miles");
        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ ts = new TeslaModelZ(5, 2341);
            ts.drive(341);
        }, "Driving more miles than limit should throw illegal argument exception");
        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ ts = new TeslaModelZ(5, 2341);
            ts.drive(-1);
        }, "Driving more miles than limit should throw illegal argument exception");

        tz.recharge();
        tz.drive(240);

        assertEquals(tz.toString(), "Tesla Z2341 (290.0 mi)", "Tesla mileage after 285 miles driven at starting mileage of 5 should be 290.0");

        // Tesla road trip test
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(50.0);
        arr.add(20.0);
        arr.add(5.0);
        arr.add(5.0);
        arr.add(20.0);
        arr.add(30.0);
        arr.add(90.0);
        arr.add(1.0);
        int numTraveled = tz.roadTrip(arr);
        assertEquals(numTraveled, 5, "The tesla should have only travelled for 5 days");

        assertEquals(tz.toString(), "Tesla Z2341 (390.0 mi)",
                "Tesla mileage after driving 385 miles after starting mileage of 5 should be 390 mi (including driving and road trip)");

        //Tesla roadtrip negative test
        ArrayList<Double> negativeArr = new ArrayList<>(); 
        negativeArr.add(-0.1);
        assertThrows(IllegalArgumentException.class, ()->{TeslaModelZ negTesla = new TeslaModelZ(4, 238); negTesla.roadTrip(negativeArr);}, "A day in a road trip with a negative number of miles for a Tesla Model Z should throw an illegal argument exception");

        //Miscellaneous Tesla road trip test, where total road trip is less than maximum range of tesla
        TeslaModelZ smallTesla = new TeslaModelZ(0, 2010);
        ArrayList<Double> smallArr = new ArrayList<>();
        smallArr.add(2.0);
        int smallDays = smallTesla.roadTrip(smallArr);
        assertEquals(smallDays, 1, 0.01, "For a road trip of one days (2 miles), the tesla should be able to complete one days and return the value 1.");
        

        // Tesla autonomous driving test
        tz.recharge();
        tz.drive(240);
        tz.driveAutonomously(500);
        assertEquals(0.0, tz.getRemainingRange(), 0.01,
                "The tesla should have droven all its possible miles when driving autonomously");

        assertEquals(tz.toString(), "Tesla Z2341 (730.0 mi)",
                "Tesla mileage after driving 725 miles should be 730 mi with starting mileage of 5 (including driving and road trip, and autonomous driving)");

        tz.recharge();
        tz.drive(100);
        tz.driveAutonomously(200);
        assertEquals(tz.getRemainingRange(), 40.0, 0.01,
                "The tesla should have driven 200 miles when asked to drive 200 miles autonomously on 240 miles of charge");

        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ ts = new TeslaModelZ(5, 2341);
            ts.driveAutonomously(-123456678);
        }, "You cannot drive a negative number of miles autonomously.");

        // Tesla canDrive test
        assertThrows(IllegalArgumentException.class, () -> {
            tz.canDrive(-1);
        }, "Tesla canDrive should throw an exception upon a negative value");
        tz.recharge();
        assertFalse(tz.canDrive(341), "Tesla can Drive function shouldn't be able to drive more than 340 miles");

        return getFailedCount();
    }
}