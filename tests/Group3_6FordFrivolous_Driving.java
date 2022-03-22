package tests;

import vehicle.FordFrivolous;
import bcatest.BCATestScenario;

public class Group3_6FordFrivolous_Driving extends BCATestScenario {

    public int runTest() {
        FordFrivolous c1 = new FordFrivolous();

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(-1);
        }, "Driving mileage cannot be negative.");

        c1.drive(0);
        assertEquals(c1.getMileage(), 0, .1, "Mileage should be 0 after first drive");

        c1.drive(30);
        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after second drive.");

        c1.drive(200);
        assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after third drive.");

        assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG() - 230, .1,
                "Remaining range of car not correct after driving tree times.");

        assertFalse(c1.canDrive(243), "Driving 243 should fail.");
        assertTrue(c1.canDrive(241), "Driving 241 should succeed.");

        c1.drive(242);
        assertEquals(c1.getMileage(), 472, .1, "Mileage should be 472 after fourth drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(1);
        }, "Driving beyond empty should fail.");

        c1.refillTank();
        assertEquals(c1.getFuelLevel(), 20, .1, "Fuel level should be 20.");

        c1.drive(472);
        assertEquals(c1.getMileage(), 944, .1, "Mileage should be 944 after fifth drive.");

        c1.refillTank(1);
        assertEquals(c1.getFuelLevel(), 1, .1, "Fuel level should be 1.");
        
        assertEquals(c1.getRemainingRange(), 23.6, .1, "Remaining range should be 23.6.");

        return getFailedCount();
    }
}
