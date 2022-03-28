package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;
import java.util.ArrayList;
import java.util.Arrays;

public class Group1_6_TeslaModelZTester extends BCATestScenario {

    public int runTest() {

        TeslaModelZ tesla = new TeslaModelZ(100, 70);
        
        assertEquals((int) tesla.getMileage(), 100, "Mileage should equal 100");
        assertThrows(IllegalArgumentException.class, () -> {tesla.drive(-1);}, "Cannot drive negative miles");
        assertEquals((int) tesla.getRemainingRange(), 340, "Remaining range should still equal 340");
        tesla.drive(0);
        assertEquals((int) tesla.getMileage(), 100, "Mileage should still equal 100");
        tesla.drive(40);
        assertEquals((int) tesla.getRemainingRange(), 300, "Remaining range should equal 300");
        assertThrows(IllegalArgumentException.class, () -> {tesla.drive(301);}, "Cannot drive more than remaining range");
        tesla.drive(300);
        assertEquals((int) tesla.getRemainingRange(), 0, "Remaining range should equal 0");

        tesla.recharge();
        assertEquals((int) tesla.getRemainingRange(), 340, "Remaining range should equal 340 after recharge");
        assertEquals(tesla.getModelNum(), 70, "Model num should equal 70");
        assertEquals(tesla.getModel(), "Z70", "Model should equal 'Z70'");
        assertEquals(tesla.toString(), "Tesla Z70 (440.0 mi)", "Tesla toString should return 'Tesla Z70 (440.0 mi)'");
        assertEquals((int) tesla.getMileage(), 440, "Mileage should equal 440");
        assertEquals((int) tesla.getMaxRange(), 340, "Max range should equal 340");
        assertEquals(tesla.getMake(), "Tesla", "Make should equal 'Tesla'");
        ArrayList<Double> invalidRoadTrip = new ArrayList<>(Arrays.asList(0.0, -20.0, -50.0, 70.0));
        assertThrows(IllegalArgumentException.class, () -> {tesla.roadTrip(invalidRoadTrip);}, "Cannot have negative distance in road trip");
        assertEquals((int) tesla.getMileage(), 440, "Mileage should still equal 440");
        ArrayList<Double> validRoadTrip = new ArrayList<>(Arrays.asList(150.0, 100.0, 50.0, 70.0));
        assertEquals(tesla.roadTrip(validRoadTrip), 3, "Should return 3 days driven");
        assertTrue(tesla.canDrive(0), "Should be able to drive 0 miles");
        assertThrows(IllegalArgumentException.class, () -> {tesla.canDrive(-1);}, "Cannot drive negative miles");

        tesla.recharge();
        assertTrue(tesla.canDrive(340), "Should be able to drive 340 miles after recharge");
        assertFalse(tesla.canDrive(341), "Should not be able to drive 341 miles");
        assertThrows(IllegalArgumentException.class, () -> {tesla.driveAutonomously(-50);}, "Cannot autonomously drive negative miles");
        tesla.driveAutonomously(0);
        assertEquals((int)tesla.getMileage(), 740, "Mileage should equal 740");
        tesla.driveAutonomously(100);
        assertEquals((int)tesla.getMileage(), 840, "Mileage should equal 840");
        tesla.driveAutonomously(300);
        assertEquals((int)tesla.getMileage(), 1080, "Mileage should equal 1080");

        return getFailedCount();
    }
}