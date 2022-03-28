package tests;

import vehicle.ChevroletBird;
import bcatest.BCATestScenario;

public class Group1_4_BirdMethodTestersNoArg extends BCATestScenario {
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();
        assertEquals(c1.getMake(), "Chevrolet", "Returns the wrong make for the car");
        assertEquals(c1.getModel(), "Bird", "Returns the wrong model of the car");
        assertTrue(c1.canFly(100), "Bird should be able to fly 100");
        assertThrows(IllegalArgumentException.class, () -> {c1.canFly(-100);}, "Bird should not be able to fly negative distance");
        assertFalse(c1.canFly(280), "Bird cannot fly distance larger than range");
        assertTrue(c1.canFly(0), "Bird should be able to fly no distance");
        assertTrue(c1.canFly(250), "Bird should be able to fly exactly max distance");
        assertFalse(c1.checkWingsExtended(), "Wings should be retracted before flight happens");
        c1.fly(250);
        assertEquals(c1.getRemainingRange(), 0, .1, "Range should be 0 after flying max distance");
        assertFalse(c1.canFly(1), "Should not be able to fly any distance");
        assertEquals(c1.getMileage(), 0, .1, "Mileage should not change after flying");
        assertTrue(c1.checkWingsExtended(), "Wings should be extended after flying");
        c1.recharge();
        assertEquals(c1.getRemainingRange(), 250, .1, "Range should be max range after recharging.");
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-100);}, "Bird should not be able to drive negative distance");
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(400);}, "Bird should not be able to drive more than max range");
        c1.drive(c1.getRemainingRange());
        assertEquals(c1.getRemainingRange(), 0, .1, "Driving remaining range should result in no more remaining range.");
        assertEquals(c1.getMileage(), 250, .1, "Mileage should be 250 after driving max range on a full charge");
        c1.recharge();
        assertEquals(c1.getRemainingRange(), 250, .1, "Recharge should refill the charge all the way back up");
        c1.drive(50);
        assertEquals(c1.getMileage(), 300, .1, "Mileage should be 300 after driving an additional 50 miles");
        assertFalse(c1.checkWingsExtended(), "Wings should be retracted after driving.");

        return getFailedCount();
    }
}

