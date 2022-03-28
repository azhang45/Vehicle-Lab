package tests;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_3FordDriving extends BCATestScenario {
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous();

        assertThrows(IllegalArgumentException.class, () -> {c1.canDrive(-1);}, "Passing a negative number into canDrive should fail");
        
        assertTrue(c1.canDrive(472), "Car should be able to drive 472 miles");

        assertFalse(c1.canDrive(473), "Car shouldn't be able to drive 473");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "Driving negative miles should fail");

        c1.drive(40);
        assertEquals(c1.getMileage(), 40, .1, "Mileage should be 40 after first drive.");

        c1.drive(100);
        assertEquals(c1.getMileage(), 140, .1, "Mileage should be 140 after second drive.");

        assertEquals(c1.getRemainingRange(), 332, .1, "Remaining range should be 332 after both drives");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(340);}, "Car should not be able to drive 340 miles");

        c1.drive(332);
        assertEquals(c1.getRemainingRange(), 0, .1, "Remaining range should be 0 after third drive.");

        c1.refillTank();
        assertEquals(c1.getRemainingRange(), 472, .1, "Remaining range should be full after refill");

        c1.refillTank();
        assertEquals(c1.getRemainingRange(), 472, .1, "Remaining range should be full after second refill");

        return getFailedCount();
    }
}
