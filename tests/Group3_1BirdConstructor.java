package tests;

import bcatest.BCATestScenario;
import vehicle.ChevroletBird;

public class Group3_1BirdConstructor extends BCATestScenario {
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird(50);
        assertFalse(c1.checkWingsExtended(), "Wings should be retracted");
        assertEquals(c1.toString(), "Chevrolet Bird (50.0 mi)", "Expected toString [Chevrolet " +
                "Bird (50.0 mi), not " + c1);
        assertEquals(c1.getMaxRange(), 250, 0.1, ("Max range should be 250.0, not " + c1.getMaxRange()));
        assertEquals(c1.getRemainingRange(), 250, 0.1, ("remaining range should be 250.0 upon creation," +
                " not " + c1.getMileage()));
        return getFailedCount();
    }
}
