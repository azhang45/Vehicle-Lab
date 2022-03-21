package tests;

import bcatest.BCATestScenario;
import vehicle.TeslaModelZ;

public class Group3_6TeslaModelZ1_Constructors extends BCATestScenario {
    public int runTest() {
        TeslaModelZ c1 = new TeslaModelZ(70);

        assertEquals(c1.getMileage(), 0, .1, "Default mileage should be zero.");

        assertEquals(c1.getMaxRange(), 340, .1, "Max range should be 340.");

        assertEquals(c1.getRemainingRange(), 340, .1, "Remaining range of car not correct at creation.");

        assertEquals(c1.toString(), "Tesla Z70 (0.0 mi)", "toString does not match");

        return getFailedCount();
    }
}
