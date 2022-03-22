package tests;

import bcatest.BCATestScenario;
import vehicle.TeslaModelZ;


public class Group3_6TeslaModelZ_Driving extends BCATestScenario {

    public int runTest() {
        TeslaModelZ c1 = new TeslaModelZ(50);

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(-1);
        }, "Driving mileage cannot be negative.");

        assertTrue(c1.canDrive(30), "canDrive should be true");
        c1.drive(30);
        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

        c1.drive(200);
        assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after second drive.");

        assertEquals(c1.getRemainingRange(), c1.getMaxRange() - 230, .1,
            "Remaining range of car not correct after driving three times.");


        assertFalse(c1.canDrive(111), "Driving 111 should fail.");
        assertTrue(c1.canDrive(109), "Driving 109 should succeed.");

        c1.drive(110);
        assertEquals(c1.getMileage(), 340, .1, "Mileage should be 340 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(5);
        }, "Driving beyond empty should fail.");

        return getFailedCount();
    }
}
