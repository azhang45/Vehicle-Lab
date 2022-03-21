package tests;

import vehicle.FordFrivolous;
import bcatest.BCATestScenario;

public class Group3_6FordFrivolous_Driving extends BCATestScenario {

    public int runTest() {
        FordFrivolous c1 = new FordFrivolous(2018);

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(-1);
        }, "Driving mileage cannot be negative.");

        assertTrue(c1.canDrive(20), "canDrive should be true");
        c1.drive(30);
        assertEquals(c1.getMileage(), 20, .1, "Mileage should be 20 after first drive.");

        c1.drive(200);
        assertEquals(c1.getMileage(), 220, .1, "Mileage should be 220 after second drive.");

        assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG() - 220, .1,
                "Remaining range of car not correct after driving twice.");

        assertFalse(c1.canDrive(252), "Driving 243 should fail.");
        assertTrue(c1.canDrive(251), "Driving 241 should succeed.");

        c1.drive(251);
        assertEquals(c1.getMileage(), 472, .1, "Mileage should be 472 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(5);
        }, "Driving beyond empty should fail.");

        return getFailedCount();
    }
}
