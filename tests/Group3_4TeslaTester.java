package tests;

import vehicle.TeslaModelZ;

import java.util.ArrayList;

import bcatest.BCATestScenario;

public class Group3_4TeslaTester extends BCATestScenario{
     public int runTest() {

        //new car with no mileage
         TeslaModelZ c1 = new TeslaModelZ(70);
         assertEquals(c1.getMileage(), 0, .1, ("Mileage should be 0"));

         //new car with mileage of 1
        TeslaModelZ c2 = new TeslaModelZ(1, 70);
        assertEquals(c2.getMileage(), 1, .1, ("Mileage should be 1"));

        //mileage cannot be -1
         assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "Driving mileage cannot be negative.");

         //max range is 340; can't drive more miles than that
         assertThrows(IllegalArgumentException.class, () -> {c1.drive(341);}, "Not enough range.");

         //car should be able to drive 10 miles
         assertTrue(c1.canDrive(10), "canDrive should be true");

         c1.drive(10);
         //mileage should now be 10 after driving ten miles
         assertEquals(c1.getMileage(), 10, .1, "Mileage should be 10 after first drive.");

         //remaining range should go down by 10 (330)
         assertEquals(c1.getRemainingRange(), 330, .1, ("Remaining range should go down by 10"));

         c1.drive(200);
         //car mileage should go down by 200
         assertEquals(c1.getMileage(), 210, .1, "Mileage should be 210 after second drive.");

         c1.recharge();
         //remaining range should become
         assertEquals(c1.getRemainingRange(), 340, .1, ("Remaining range should be 340"));

         c1.getMaxRange();
         //max range should be 340
         assertEquals(c1.getMaxRange(), 340, .1, ("Max range is 340"));

         //return model and modelNum correctly
         assertEquals(c1.getMake(), "Tesla", "the make is 'Tesla', not " + c1.getMake());
         assertEquals(c1.getModelNum(), 70, "the model number is 70, not " + c1.getModelNum());
         assertEquals(c1.getModel(), "Z70", "the model should be Z70, not " + c1.getModel());

         //break

        TeslaModelZ c3 = new TeslaModelZ(70);

        assertTrue(c3.canDrive(1), "canDrive should be true for positive values");

        assertFalse(c3.canDrive(341), "Driving mileage should not be greater than 340 miles.");
        c3.toString();

        assertThrows(IllegalArgumentException.class, () -> {c1.driveAutonomously(-1);}, "Self Driving miles cannot be negative.");
        c3.driveAutonomously(350);

        assertEquals(c3.getMileage(), 340, .1, "Mileage should be 340 after first drive because battery will die.");

        ArrayList<Double> L = new ArrayList<>();
        L.add(1.0);
        L.add(2.0);
        L.add(-1.0);
        assertThrows(IllegalArgumentException.class, () -> {c3.roadTrip(L);}, "Miles must be negative.");

        c3.recharge();
        ArrayList<Double> L2 = new ArrayList<>();
        L2.add(134.0);
        L2.add(75.0);
        L2.add(21.0);
        L2.add(876.0);
        assertEquals(c3.roadTrip(L2), 3, 0.1, "Mileage should return number of days successfully driven");


         return getFailedCount();

    }
}
