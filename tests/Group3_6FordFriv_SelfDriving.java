package tests;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;
import vehicle.HondaAccordian;

public class Group3_6FordFriv_SelfDriving extends BCATestScenario {

    @Override
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous(2018);

        assertEquals(c1.getFuelLevel(), 20.0, .1, "Gas should be full when initialized");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.driveAutonomously(-1);
        }, "Driving mileage cannot be negative.");

        assertTrue(c1.canDrive(30), "canDrive should be true");
        c1.driveAutonomously(30);
        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

        c1.driveAutonomously(200);
        assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after second drive.");

        assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG() - 230, .1,
                "Remaining range of car not correct after driving twice.");

        assertFalse(c1.canDrive(252), "Driving 252 should fail.");
        assertTrue(c1.canDrive(251), "Driving 251 should succeed.");

        c1.drive(251);
        assertEquals(c1.getMileage(), 481, .1, "Mileage should be 481 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.driveAutonomously(5);
        }, "Driving beyond empty should fail.");

        return getFailedCount();
    }
}
