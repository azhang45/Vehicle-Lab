package tests;

import vehicle.TeslaModelZ;

import java.util.Arrays;
import java.util.List;

import bcatest.BCATestScenario;

public class Group1_4_TeslaCarMethodTester extends BCATestScenario {

    public int runTest() {
        TeslaModelZ t1 = new TeslaModelZ(60);
        List<Double> list = Arrays.asList(3.0, 4.0, 6.0, 7.0);
        List<Double> list1 = Arrays.asList(3.0, 4.0, -6.0, 7.0);
        List<Double> list2 = Arrays.asList(30.0, 20.0, 150.0, 1000.0);
        assertTrue(t1.canDrive(0), "Tesla can drive no distance");
        assertTrue(t1.canDrive(10), "Tesla can drive 10");
        assertFalse(t1.canDrive(500), "Tesla cannot drive 500");
        assertThrows(IllegalArgumentException.class, () -> {t1.canDrive(-1);}, "Tesla cannot drive negative distance");
        assertEquals(t1.getModelNum(), 60, "model number should be 60");
        assertEquals(t1.getModel(), "Z60", "model should be Z60");        
        assertEquals(t1.getMake(), "Tesla", "make should be Tesla");
        t1.roadTrip(list);
        assertEquals(t1.getMileage(), 20.0, 0.1, "Mileage should be 20 after a 20 mile road trip.");
        assertThrows(IllegalArgumentException.class, () -> {t1.roadTrip(list1);}, "Tesla should not be able to drive negative miles");
        assertEquals(t1.getMileage(), 20.0, 0.1, "Mileage shouldn't change as previous roadtrip was invalid");
        TeslaModelZ t2 = new TeslaModelZ(60);
        t2.roadTrip(list2);
        assertEquals(t2.getMileage(), 200.0, 0.1, "Mileage should stop decreasing once the car cannot drive any more miles.");
        return getFailedCount();
    }
}