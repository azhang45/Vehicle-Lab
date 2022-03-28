package tests;

import java.util.ArrayList;

import bcatest.BCATestScenario;
import vehicle.ChevroletBird;

public class Group3_5ChevorletBirdNoArgsConstructor extends BCATestScenario{

    @Override
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        assertEquals(c1.getMileage(), 0, 0.1, "Mileage is not zero");                 
        assertEquals(c1.getMaxRange(), 250, 0.1, "Range should be 250 miles.");


        assertFalse(c1.checkWingsExtended(), "Wings should start retracted");
        assertEquals(c1.getRemainingRange(), 250, 0.1, "getRemainingRange(x) does not return 250");

        assertTrue(c1.canFly(0),"canFly(0) is supposed to return true.");
        assertThrows(IllegalArgumentException.class, () -> {c1.canFly(-1);}, "flying mileage cannot be negative");
        assertFalse(c1.canFly(251), "canFly(251) should return false");
        assertTrue(c1.canFly(250), "canFly(250) should return true");

        assertEquals(c1.toString(), "Chevrolet Bird (0.0 mi)", "toString is incorrect");

        //road trip tests
        ArrayList<Double> l = new ArrayList<>();
        l.add(56.0);
        l.add(-1.0);
        l.add(2.0);
        assertThrows(IllegalArgumentException.class, () -> {c1.roadTrip(l);}, "driving mileage cannot be negative for any day in road trip");
        
        l.clear();
        l.add(0.0);
        assertEquals(c1.roadTrip(l), 1, .1, "roadTrip(0) should return 1");
        
        l.clear();
        l.add(25.0);
        l.add(35.0);
        l.add(100.0);
        l.add(85.0);
        l.add(95.0);
        l.add(70.0);
        assertEquals(c1.roadTrip(l), 4, .1, "roadTrip([25, 35, 100, 85, 95, 70]) should return 4");
        
        c1.recharge();
        assertTrue(c1.canDrive(0), "canDrive(0) should return true");
        assertThrows(IllegalArgumentException.class, () -> {c1.canDrive(-1);}, "you cannot drive a negative number of miles");
        assertTrue(c1.canDrive(250), "canDrive(250) should return true");
        assertFalse(c1.canDrive(251), "canDrive(251) should return false");

        return getFailedCount();
    }
    
}