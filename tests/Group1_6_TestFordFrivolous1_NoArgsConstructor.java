package tests;

import vehicle.FordFrivolous;
import bcatest.BCATestScenario;

import java.util.ArrayList;
import java.util.Arrays;

public class Group1_6_TestFordFrivolous1_NoArgsConstructor extends BCATestScenario {

    public int runTest() {

        FordFrivolous f1 = new FordFrivolous();

        assertEquals(f1.getMake(), "Ford", "Make should be Ford");
        assertEquals(f1.getModel(), "Frivolous", "Model should be Frivolous");
        assertEquals(f1.getMileage(), 0.0, 0.1, "Mileage starts off at 0");
        assertEquals(f1.getFuelCapacity(), 20.0, 0.1, "Fuel Capacity starts at 20 gallons");
        assertEquals(f1.getFuelLevel(), f1.getFuelCapacity(), 0.1, "Fuel Level should match Fuel Capacity (20 gallons)");
        assertEquals(f1.getMPG(), 23.6, 0.1, "MPG should be 23.6");
        assertEquals(f1.getRemainingRange(), f1.getFuelCapacity() * f1.getMPG(), 0.1, "Remaining Range should be fuel capacity * mpg");
        assertEquals(f1.toString(), "Ford Frivolous (0.0 mi)", "String should be Ford Frivolous (0.0 mi)");
        assertThrows(IllegalArgumentException.class, () -> {f1.canFly(-1);}, "Exception thrown because cannot fly negative miles");
        assertTrue(f1.canFly(0), "Return true because can fly 0 miles");
        assertTrue(f1.canFly(157.3), "Return true: max out situation with 157.3 mi (uses 3 times more gas in flying)");
        assertFalse(f1.canFly(158), "Return false: more than the maximum miles");
        assertThrows(IllegalArgumentException.class, () -> {f1.canDrive(-1);}, "Exception thrown because cannot drive negative miles");
        assertTrue(f1.canDrive(0), "Return true: can drive 0 miles");
        assertTrue(f1.canDrive(157.3), "Return true: can drive because less than maximum (157.3 mi)");
        assertFalse(f1.canDrive(473), "Return false: cannot drive more than maximum capacity (473 mi)");
        assertEquals(f1.getRemainingRange(), 472, 0.1, "Have not driven yet so remaining range should still be at 472");;
        assertEquals(f1.getFuelLevel(), 20, 0.1, "Fuel Level has not changed from beginning either so should be at 20");
        ArrayList<Double> invalidRoadTrip = new ArrayList<>(Arrays.asList(60.0, -178.0, 90.0, 45.0));;
        assertThrows(IllegalArgumentException.class, () -> {f1.roadTrip(invalidRoadTrip);}, "Cannot return days because of negative miles");
        assertEquals(f1.getMileage(), 0, 0.1, "Mileage should be 0 because of negative miles");
        ArrayList<Double> zeroRoadTrip = new ArrayList<>(Arrays.asList(0.0));
        assertEquals(f1.roadTrip(zeroRoadTrip), 1, "Should have returned one day");
        ArrayList<Double> validRoadTrip = new ArrayList<>(Arrays.asList(100.0, 80.0, 45.0, 20.0, 250.0));;
        assertEquals(f1.roadTrip(validRoadTrip), 4, "Should return 4 because it can go for 4 days.");
        assertEquals(f1.getMileage(), 245.0, 0.1, "Mileage should be 245 validRoadTrip miles got added");

        return getFailedCount();
    }
}