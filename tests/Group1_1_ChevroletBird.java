package tests;

import vehicle.ChevroletBird;
import bcatest.BCATestScenario;

public class Group1_1_ChevroletBird extends BCATestScenario{

    @Override
    public int runTest() {
        assertThrows(IllegalArgumentException.class, () -> {new ChevroletBird(-1);}, "Mileage cannot be negative.");

        ChevroletBird b = new ChevroletBird(0);
        assertEquals(b.getMake(), "Chevrolet", "Make is Chevrolet");
        assertEquals(b.getModel(), "Bird", "Model is Bird");
        assertEquals(b.getMileage(), 0.0, .1, "Mileage is 0");
        assertEquals(b.getMaxRange(), 250.0, .1, "Max range is 250.0 mi");

        ChevroletBird c = new ChevroletBird();
        assertEquals(c.getMake(), "Chevrolet", "Make is Chevrolet");
        assertEquals(c.getModel(), "Bird", "Model is Bird");
        assertEquals(c.getMileage(), 0, .1, "Mileage is 0.0 mi");
        assertEquals(c.getMaxRange(), 250.0, .1, "Max range is 250.0 mi");

        ChevroletBird d = new ChevroletBird(200000);
        assertEquals(c.getMake(), "Chevrolet", "Make is Chevrolet");
        assertEquals(c.getModel(), "Bird", "Model is Bird");
        assertEquals(d.getMileage(), 200000, .1, "Mileage is 200000.0");
        assertEquals(d.getMaxRange(), 250.0, .1, "Max range is 250.0 mi");

        ChevroletBird e = new ChevroletBird();
        assertFalse(e.checkWingsExtended(), "Car e - Wings should not be extended");
        //assertEquals(e.checkWingsExtended(), "false");
        e.fly(0);
        assertTrue(e.checkWingsExtended(), "Car e - Wings should be extended");
        //assertEquals(e.checkWingsExtended(), "true");

        ChevroletBird f = new ChevroletBird();
        f.drive(0);
        assertFalse(f.checkWingsExtended(), "Car f - Wings should not be extended");
        //assertEquals(e.checkWingsExtended(), "false");
        assertEquals(f.getMileage(), 0.0, .1, "Mileage is 0.0 mi");

        assertThrows(IllegalArgumentException.class, () -> {f.drive(-1);}, "Driving mileage cannot be negative.");

        ChevroletBird g = new ChevroletBird();
        assertThrows(IllegalArgumentException.class, () -> {g.drive(1000000);}, "Driving over the max range limit. "); 
        //assertFalse(e.checkWingsExtended(), "Wings should not be extended");
        //assertEquals(e.checkWingsExtended(), "false");
        //assertEquals(g.getMileage(), 1000000, .1, "Mileage is 1000000.0 mi");

        return getFailedCount();
    }
}
