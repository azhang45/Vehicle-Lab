package tests;
import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_5FordFrivolousMethods extends BCATestScenario {

    public int runTest() { 
        FordFrivolous f = new FordFrivolous(0);

        //drive tests
        assertThrows(IllegalArgumentException.class, () -> {f.drive(-1);}, "Driving mileage cannot be -1");

        assertTrue(f.canDrive(0), "canDrive(0) should be true");
        f.drive(0);
        assertEquals(f.getMileage(), 0, .1, "Mileage should be zero after first driving zero miles");
        assertEquals(f.getFuelLevel(), 20, .1, "Fuel Level should be 20 after first drive");
        assertEquals(f.getRemainingRange(), 472, .1, "Remaining range should be 472 after first drive");

        f.drive(354);
        assertEquals(f.getMileage(), 354, .1, "Mileage should be 354 after second drive");
        assertEquals(f.getFuelLevel(), 5, .1, "Fuel Level should be 5 after second drive");
        assertEquals(f.getRemainingRange(), 118, .1, "Remaining range should be 118 after second drive");

        f.refillTank();
        assertEquals(f.getFuelLevel(), 20, .1, "Fuel Level should be 20 after refuel");
        assertEquals(f.getRemainingRange(), 472, .1, "Remaining range should be 472 after refuel");

        f.drive(472);
        assertEquals(f.getFuelLevel(), 0, .1, "Fuel Level should be 0 after third drive");
        assertEquals(f.getRemainingRange(), 0, .1, "Remaining range should be 0 after third drive");

        assertFalse(f.canDrive(1), "canDrive(1) should be false");
        assertEquals(f.getMileage(), 826, .1, "Mileage should be 826 after drive tests");

        f.refillTank();

        //fly tests
        assertThrows(IllegalArgumentException.class, () -> {f.fly(-1);}, "Can't fly negative miles");

        assertTrue(f.canFly(0), "canFly(0) should be true");
        f.fly(0);
        assertEquals(f.getMileage(), 826, .1, "Mileage should be 826 after first fly");
        assertEquals(f.getFuelLevel(), 20, .1, "Fuel Level should be 20 after first drive");

        assertTrue(f.canFly(63), "canFly(63) should be true");
        f.fly(63);
        assertEquals(f.getFuelLevel(), 12, .1, "Fuel Level should be 12 after second fly");

        f.refillTank();

        assertTrue(f.canFly(157.3), "canFly(157.3) should be true");
        f.fly(157.3);
        assertEquals(f.getFuelLevel(), 0, .1, "Fuel Level should be 0 after third fly");

        assertFalse(f.canFly(1), "canFly(1) should be false when there is no fuel");
        assertEquals(f.getMileage(), 826, .1, "Mileage should be 826 after flying tests");
        f.refillTank();
        
        //autonomous driving tests
        assertThrows(IllegalArgumentException.class, () -> {f.driveAutonomously(-1);}, "Autonomous driving mileage cannot be -1");

        f.drive(0);
        assertEquals(f.getMileage(), 826, .1, "Mileage should be 826 after first autonomous driving");
        assertEquals(f.getFuelLevel(), 20, .1, "Fuel Level should be 20 after first autonomous drive");

        f.driveAutonomously(129.8);
        assertEquals(f.getMileage(), 955.8, .1, "Mileage should be 955.8 after second autonomous drive");
        assertEquals(f.getFuelLevel(), 9, .1, "Fuel Level should be 9 after second autonomous drive");

        f.refillTank();
        assertEquals(f.getFuelLevel(), 20, .1, "Fuel Level should be 20 after refuel");

        f.driveAutonomously(236);
        assertEquals(f.getFuelLevel(), 0, .1, "Fuel Level should be 0 after third autonomous drive");
        assertEquals(f.getMileage(), 1191.8, .1, "Mileage should be 1191.8 after third autonomous drive");

        f.driveAutonomously(1);
        assertEquals(f.getFuelLevel(), 0, .1, "Fuel Level should be 0 after trying to autonomously drive with no fuel");
        assertEquals(f.getMileage(), 1191.8, .1, "Mileage should be 1191.8 after trying to autonomously drive with no fuel");

        f.refillTank();

        f.driveAutonomously(100);
        assertEquals(f.getMileage(), 1291.8, .1, "not working");

        f.driveAutonomously(400);
        assertEquals(f.getMileage(), 1427.8, .1, "not working 2");

        
        return getFailedCount();
    }
}