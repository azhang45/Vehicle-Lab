package tests;

import vehicle.FordFrivolous;
import bcatest.BCATestScenario;

public class Group1_3_FordFrivolous extends BCATestScenario {

    @Override
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous(100);
        
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(472.1);}, "Cannot drive more than gas allows for.");

        assertEquals(c1.getMileage(), 100, .1, "Mileage should be 100 at intialization.");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "Cannot drive negative amount of miles.");

        c1.drive(472);

        assertEquals(c1.getMileage(), 572.0, .1, "Car's mileage is wrong (should be 572 miles).");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(2);}, "Cannot drive more than gas allows for.");

        assertFalse(c1.canDrive(10), "Should return false; Not enough miles");

        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(-1);}, "Cannot refill negative gallons in gas tank.");

        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(100);}, "Cannot refill over 20 gallons in the gas tank.");

        c1.refillTank();

        assertEquals(c1.getFuelLevel(), c1.getFuelCapacity(), .1, "refillTank method does not refill tank to the maximum amount.");

        assertTrue(c1.canFly(5), "Car is unable to fly 5 miles despite having a full tank.");

        assertThrows(IllegalArgumentException.class, () -> {c1.fly(1000);}, "Cannot fly more than gas allows for.");

        assertThrows(IllegalArgumentException.class, () -> {c1.fly(-1);}, "Cannot fly negative amount of miles.");

        c1.fly(100);

        assertEquals(c1.getFuelLevel(), 7.3, .1, "Flying the car returns incorrect fuel level.");
        
        return getFailedCount();
    }
    
}