package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

/**
 * Group1_2_TeslaModelZ_Metadata
 */
public class Group1_2_TeslaModelZ_Driving extends BCATestScenario {

    double DELTA = .1;

    @Override
    public int runTest() {
        var tesla = new TeslaModelZ(400.0, 123);

        assertTrue(tesla.canDrive(340.0), "Tesla should initially be able to drive its max range.");
        assertFalse(tesla.canDrive(341.0), "Tesla should not be able to drive more than its max range.");
        assertTrue(tesla.canDrive(0.0), "Tesla should technically be able to drive 0 miles.");

        assertThrows(IllegalArgumentException.class, () -> tesla.canDrive(-1.0),
                "Tesla should throw exception when it's checked if it can drive negative miles.");

        tesla.drive(200.0);
        assertEquals(tesla.getMileage(), 600.0, DELTA, "Tesla should have 600 miles driven.");

        tesla.drive(40.0);
        assertEquals(tesla.getMileage(), 640.0, DELTA, "Tesla should have 640 miles driven.");
        assertThrows(IllegalArgumentException.class, () -> tesla.drive(-1.0),
                "Tesla should throw exception when you try to drive negative miles.");

        assertEquals(tesla.getRemainingRange(), 100.0, DELTA, "Tesla should have 100 miles left.");
        assertThrows(IllegalArgumentException.class, () -> tesla.drive(101.0),
                "Tesla should throw exception because it has fewer than 101 miles of range left.");

        tesla.drive(100.0);
        tesla.drive(0.0);

        assertEquals(tesla.getRemainingRange(), 0.0, DELTA, "Tesla should have 0 miles left.");
        assertEquals(tesla.getMaxRange(), 340.0, DELTA, "Tesla should have 340 miles as its max range.");

        tesla.recharge();
        assertEquals(tesla.getRemainingRange(), 340.0, DELTA, "Tesla should have 340 miles left.");

        assertThrows(IllegalArgumentException.class, () -> tesla.driveAutonomously(-1.0),
                "Tesla should throw exception when you try to drive negative miles, even autonomously.");

        tesla.driveAutonomously(240.0);
        assertEquals(tesla.getMileage(), 980.0, DELTA, "Tesla should have 980 miles driven.");

        tesla.driveAutonomously(150.0);
        assertEquals(tesla.getMileage(), 1080.0, DELTA, "Tesla should have 1080 miles driven.");
        assertEquals(tesla.getRemainingRange(), 0.0, DELTA, "Tesla should have 0 miles left.");
        return getFailedCount();
    }

}