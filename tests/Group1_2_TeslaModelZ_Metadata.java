package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

/**
 * Group1_2_TeslaModelZ_Metadata
 */
public class Group1_2_TeslaModelZ_Metadata extends BCATestScenario {

    double DELTA = .1;

    @Override
    public int runTest() {
        TeslaModelZ tz = new TeslaModelZ(123);

        assertEquals(tz.getModelNum(), 123, "Incorrect model number");
        assertEquals(tz.getModel(), "Z123", "Incorrect total model");
        assertEquals(tz.toString(), "Tesla Z123 (0.0 mi)", "toString incorrect");

        assertEquals(tz.getMaxRange(), 340.0, DELTA, "Incorrect max range");
        assertEquals(tz.getRemainingRange(), 340.0, DELTA, "Incorrect remaining range");

        assertEquals(tz.getMake(), "Tesla", "Incorrect manufacturer");
        assertEquals(tz.getMileage(), 0, DELTA, "Incorrect starting mileage");

        return 0;
    }

}