package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

public class Group3_6TeslaModelZ2_Constructors extends BCATestScenario {

    public int runTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ z2 = new TeslaModelZ(-1, 10);
        }, "Starting mileage cannot be negative.");

        TeslaModelZ z2 = new TeslaModelZ(1, 5);

        assertEquals(z2.getMileage(), 1, .1, "Mileage should be 1");

        assertEquals(z2.getModel(), "Z5", "Incorrect model number");

        assertEquals(z2.toString(), "Tesla Z5 (1.0 mi)", "toString does not match");

        assertEquals(z2.getRemainingRange(), 340, .1, "Remaining range of car not correct at creation.");

        assertEquals(z2.getMaxRange(), 340, .1, "The max range is incorrect at creation.");

        return getFailedCount();
    }
}