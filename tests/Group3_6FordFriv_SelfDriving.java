package tests;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_6FordFriv_SelfDriving extends BCATestScenario {

    @Override
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous(50);

        assertEquals(c1.getFuelLevel(), 20.0, .1, "Gas should be full when initialized");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.driveAutonomously(-1);
        }, "Driving mileage cannot be negative.");

        c1.driveAutonomously(236);
        assertEquals(c1.getMileage(), 286, .1, "Mileage should be 286 after first drive.");

        assertEquals(c1.getFuelLevel(), 0, .1, "Fuel level should be 0 after first drive.");

        c1.driveAutonomously(0);
        assertEquals(c1.getMileage(), 286, .1, "Mileage should be 286 after second drive.");

        c1.driveAutonomously(1);
        assertEquals(c1.getMileage(), 286, .1, "Mileage should be 286 after third drive.");
        assertEquals(c1.getFuelLevel(), 0, .1, "Fuel level should be 0 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.refillTank(-1);
        }, "Refill gallons cannot be negative.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.refillTank(21);
        }, "Refill gallons cannot go over the max fuel capacity.");

        c1.refillTank(11.5);
        assertEquals(c1.getFuelLevel(), 11.5, .1, "Fuel level should be 11.5 after refill.");

        assertEquals(c1.getRemainingRange(), c1.getFuelLevel() * c1.getMPG(), .1,
                "Remaining range of car should be 271.4 after refill.");

        return getFailedCount();
    }
}
