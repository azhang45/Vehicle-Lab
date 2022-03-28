package tests;

import vehicle.FordFrivolous;
import bcatest.BCATestScenario;

public class Group1_6_TestFordFrivolous2_Methods extends BCATestScenario {

    public int runTest() {
        FordFrivolous f1 = new FordFrivolous(0);

        assertEquals(f1.getMake(), "Ford", "Make should be Ford");
        assertEquals(f1.getModel(), "Frivolous", "Model should be Frivolous");
        assertEquals(f1.getMileage(), 0.0, 0.1, "Mileage starts off at 0");
        assertEquals(f1.getFuelCapacity(), 20.0, 0.1, "Fuel Capacity starts at 20 gallons");
        assertEquals(f1.getFuelLevel(), f1.getFuelCapacity(), 0.1, "Fuel Level should match Fuel Capacity (20 gallons)");
        assertEquals(f1.getMPG(), 23.6, 0.1, "MPG should be 23.6");
        assertEquals(f1.getRemainingRange(), f1.getFuelCapacity() * f1.getMPG(), 0.1, "Remaining Range should be fuel capacity * mpg");
        assertEquals(f1.toString(), "Ford Frivolous (0.0 mi)", "String should be Ford Frivolous (0.0 mi)");
        assertThrows(IllegalArgumentException.class, () -> {f1.drive(-1);}, "Cannot drive negative miles");
        assertThrows(IllegalArgumentException.class, () -> {f1.canDrive(-1);}, "Cannot drive negative miles");
        f1.drive(0);  
        assertEquals( f1.getMileage(), 0, .1, "Mileage should still be 0.");
        assertTrue(f1.canDrive(118), "Your Ford should currently be at 118 miles of range.");
        f1.drive(118);
        assertEquals(f1.getMileage(), 118, .1, "Mileage should be 118.");
        assertEquals(f1.getFuelLevel(), 15, .1, "Fuel Level should be 15.");
        assertEquals(f1.getRemainingRange(), 354, .1, "Fuel Level should be 354.");

        f1.refillTank();
        assertEquals(f1.getFuelCapacity(), 20, .1, "Your fuel capacity should be 20.");
        assertEquals(f1.getFuelLevel(), 20, .1, "Your fuel level should be 20.");
        assertEquals(f1.getRemainingRange(), 472, .1, "Remaining Range should be 472.");
        f1.drive(472);
        assertEquals(f1.getFuelLevel(), 0, .1, "Your fuel level should be 0.");
        assertEquals(f1.getRemainingRange(), 0, .1, "Remaining Range should be 0.");
        assertFalse(f1.canDrive(1), "Cannot drive because remaining range is 0.");
        assertThrows(IllegalArgumentException.class, () -> {f1.drive(1);}, "Fuel level is zero... cannot go below.");
        assertEquals(f1.getMileage(), 590, .1, "Mileage should be 590");

        f1.refillTank();
        assertThrows(IllegalArgumentException.class, () -> {f1.fly(-1);}, "Cannot fly neg distance.");
        f1.fly(0);
        assertEquals(f1.getMileage(), 590, .1, "Mileage should still be 590.");
        assertEquals(f1.getFuelLevel(), 20, .1, "Your fuel level should remain at 20.");
        assertTrue(f1.canFly(47), "Verify true.");
        f1.fly(47);
        assertEquals(f1.getMileage(), 590, .1, "Mileage should still be 590.");
        assertEquals(f1.getFuelLevel(), 14, .1, "Your fuel level should remain at 14.");

        f1.refillTank();
        assertTrue(f1.canFly(157.3), "Verify true.");
        f1.fly(157.3);
        assertEquals(f1.getMileage(), 590, .1, "Mileage should still be 590.");
        assertEquals(f1.getFuelLevel(), 0, .1, "Your fuel level should remain at 0.");
        assertFalse(f1.canFly(1), "Verify false because fuel level is already at 0.");

        f1.refillTank();
        assertEquals(f1.getFuelLevel(), 20, .1, "Your fuel level should be back at 20.");
        assertThrows(IllegalArgumentException.class, () -> {f1.driveAutonomously(-1);}, "Cannot autonomously drive negative miles.");
        f1.driveAutonomously(0);
        f1.driveAutonomously(70.8);
        assertEquals(f1.getMileage(), 660.8, 0.1, "Verify mileage is now 660.8.");
        assertEquals(f1.getFuelLevel(), 14, .1, "Your fuel level should be 14.");

        f1.refillTank();
        assertEquals(f1.getFuelLevel(), 20, .1, "Your fuel level should be back at 20.");
        f1.driveAutonomously(236);
        assertEquals(f1.getMileage(), 896.8, .1, "Verify mileage is now 896.8.");
        assertEquals(f1.getFuelLevel(), 0, .1, "Your fuel level should be 0.");
        f1.driveAutonomously(1);
        assertEquals(f1.getMileage(), 896.8, 0.1, "Verify mileage should still be 896.8.");
        assertEquals(f1.getFuelLevel(), 0, .1, "Your fuel level should still be 0.");

        f1.refillTank();
        assertEquals(f1.getFuelLevel(), 20, .1, "Your fuel level should be back at 20.");
        f1.driveAutonomously(100);
        assertEquals(f1.getMileage(), 996.8, 0.1, "Mileage should equal 996.8");
        f1.driveAutonomously(400);
        assertEquals(f1.getMileage(), 1132.8, 0.1, "Mileage should equal 1368.8");

        return getFailedCount();
    }
}