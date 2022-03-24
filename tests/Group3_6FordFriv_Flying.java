package tests;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_6FordFriv_Flying extends BCATestScenario {

    @Override
    public int runTest() {

        FordFrivolous c1 = new FordFrivolous(2000);
        assertEquals(c1.getMileage(), 2000, .1, "Mileage should be 2000 when initialized.");
        assertEquals(c1.getFuelLevel(), 20, .1, "Gas should be full when initialized.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.canFly(-1);
        }, "Can fly mileage cannot be negative.");

        assertTrue(c1.canFly(157), "Flying 157 should succeed.");
        assertFalse(c1.canFly(157.45), "Flying 157.45 should fail.");
        assertFalse(c1.canFly(158), "Flying 158 should fail.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.fly(-1);
        }, "Flying mileage cannot be negative.");

        c1.fly(149);
        assertEquals(c1.getMileage(), 2000, .1, "Mileage should be 2000 after first fly.");
        assertEquals(c1.getFuelLevel(), 1.1, .1, "Fuel level should be about 1.1 after first fly.");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.fly(30);
        }, "Not enough fuel to fly.");

        assertTrue(c1.canFly(0), "Flying 0 should succeed.");

        

        return 0;
    }
}
