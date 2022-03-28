package tests;

import java.util.ArrayList;
import java.util.List;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_5FordFrivolousNoArgsConstructor extends BCATestScenario{

    @Override
    public int runTest() {
        FordFrivolous f = new FordFrivolous();

        assertEquals(f.getMileage(), 0, 0.1, "Mileage hould be zero after car is created");                 
        assertEquals(f.getMPG(), 23.6, 0.1, "MPG should be 23.6");

        assertEquals(f.getFuelLevel(), 20, .1, "Fuel Level should be 20 gal after car is created");
        assertEquals(f.getFuelCapacity(), 20, .1, "Fuel capacity should be 20 gal after car is created");
        assertEquals(f.toString(), "Ford Frivolous (0.0 mi)", "to string does not match");
        assertEquals(f.getRemainingRange(), 472, .1, "remaining range should be 472 after car is created");

        //can fly tests
        assertThrows(IllegalArgumentException.class, () -> {f.canFly(-1);}, "Flying mileage cannot be -1");
        assertTrue(f.canFly(0), "canFly(0) on full tank should return true");
        assertTrue(f.canFly(157.3), "canFly(157.3) on full tank should return true");
        assertFalse(f.canFly(158), "canFly(158) on full tank should return false");

        //road trip tests
        ArrayList<Double> l = new ArrayList<>();
        l.add(5.0);
        l.add(6.0);
        l.add(-1.0);
        assertThrows(IllegalArgumentException.class, () -> {f.roadTrip(l);}, "driving mileage cannot be negative for any day in road trip");
        
        l.clear();
        l.add(0.0);
        assertEquals(f.roadTrip(l), 1, .1, "roadTrip(0) should return 1");
        
        l.clear();
        l.add(70.0);
        l.add(8.0);
        l.add(65.0);
        l.add(180.0);
        l.add(95.0);
        l.add(270.0);
        assertEquals(f.roadTrip(l), 5, .1, "roadTrip([70, 8, 65, 180, 95, 270]) should return 5");

        //can drive tests
        f.refillTank();
        assertThrows(IllegalArgumentException.class, () -> {f.canDrive(-1);}, "Driving mileage cannot be -1");
        assertTrue(f.canDrive(0), "canDrive(0) on full tank should return true");
        assertTrue(f.canDrive(472), "canDrive(472) on full tank should return true");
        assertFalse(f.canDrive(473), "canDrive(473) on full tank should return false");

        return getFailedCount();
    }
    
}

