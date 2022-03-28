package tests;

import vehicle.ChevroletBird;

import java.util.ArrayList;

import bcatest.BCATestScenario;

public class Group3_4BirdTester extends BCATestScenario {
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        // 1
        assertEquals(c1.getMileage(), 0, 0.1, "Mileage should be 0, not: " + c1.getMileage());
        // 2
        c1.drive(10);
        assertFalse(c1.checkWingsExtended(), "checkWingsExtended() should return false before driving");
        assertEquals(c1.getMileage(), 10, .1, "Mileage should be 10 after first drive.");
        // 3
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(251);}, "Driving 251 is beyond its max.");
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "cannot drive negative miles.");
        // 4
        double beforefly = c1.getMileage();
        c1.fly(5.5);
        assertEquals(c1.getMileage(), beforefly, 0.01, "Mileage should not change after fly");
        assertTrue(c1.checkWingsExtended(), "Wings should be extended (true) after fly");
        // 5
        assertThrows(IllegalArgumentException.class, () -> {c1.fly(-1);}, "Cannot fly negative miles");
        // 6
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(1 + c1.getRemainingRange());}, "Should not be able to drive more than it's remaining range");
        // 7 and 9
        c1.recharge();
        assertEquals(c1.getRemainingRange(), 250, 0.1, "recharge() should reset remaining range to 250");
        assertEquals(c1.getMaxRange(), 250, 0.1, "max range should be 250");
        // 8
        // come back to this
        // 10 
        assertFalse(c1.canDrive(251), "Cannot drive over max range, so should return false");
        //11, 12, and 13
        assertThrows(IllegalArgumentException.class, () -> {c1.canDrive(-1);}, "When miles is negative it should throw an error.");
        assertTrue(c1.canDrive(250), "The car should be able to drive this distance.");
        assertTrue(c1.canDrive(1), "The car should be able to drive this distance.");
        //14
        assertEquals(c1.toString(), "Chevrolet Bird (" + c1.getMileage() + " mi)", "Your toString method is incorrect");
        //15, 16
        assertEquals(c1.getMake(), "Chevrolet", "The car's make should be 'Chevrolet'");
        assertEquals(c1.getModel(), "Bird", "The car's model should be 'Bird'");
        //17, 18, 19, 20
        ArrayList<Double> L = new ArrayList<>();
        L.add(1.0);
        L.add(2.0);
        L.add(3.0);
        L.add(-1.0);
        assertThrows(IllegalArgumentException.class, () -> {c1.roadTrip(L);}, "Road Trip should throw an error when a negative value is passed through.");
        //new List [134, 75, 21, 876]
        L.set(0, 134.0);
        L.set(1, 75.0);
        L.set(2, 21.0);
        L.set(3, 876.0);
        assertEquals(c1.roadTrip(L), 3, "The method should have returned 3.");
        //21, 22
        ChevroletBird one = new ChevroletBird(1);
        assertEquals((int)one.getMileage(), 1, "The bird should have been created with mileage one.");
        assertThrows(IllegalArgumentException.class, () -> {ChevroletBird negative = new ChevroletBird(-1);}, "Starting mileage should throw an error if negative.");
        // 24 and 25
        ChevroletBird c2 = new ChevroletBird();
        assertThrows(IllegalArgumentException.class, () -> {c2.fly(1 + c2.getRemainingRange());}, "Should not be able to fly more than it's remaining range");
        assertThrows(IllegalArgumentException.class, () -> {c2.fly(1 + c2.getMaxRange());}, "Should not be able to fly more than it's Max range");
        // 26 
        c2.fly(30);
        assertEquals(c2.getMileage(), 0, 0.1, "Odometer should not change after fly");
        assertEquals(c2.getRemainingRange(), c2.getMaxRange() - 30, 0.1, "Gas should go down by 30 after fly(30)");

        return getFailedCount();
    }
}
