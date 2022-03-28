package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

public class Group3_2TeslaConstructors extends BCATestScenario {
    public int runTest() {
        TeslaModelZ tz = new TeslaModelZ(2341);
        assertEquals(tz.getModelNum(), 2341, "Model number should start at 2341 for TeslaModelZ");
        assertEquals(tz.getMake(), "Tesla", "Make of Tesla should be Tesla");
        assertEquals(tz.getModel(), "Z2341", "Get model should return Z2341");
        assertEquals(tz.getMileage(), 0.0, 0.0001, "Mileage should be 0");
        assertEquals(tz.toString(), "Tesla Z2341 (0.0 mi)", "Tesla to string not working");
        assertEquals(tz.getMaxRange(), 340.0, 0.001, "Tesla max range should be 340");
        assertEquals(tz.getRemainingRange(), 340.0, 0.001,
                "Tesla remaining range should be 340 at beginning of drive.");

        tz = new TeslaModelZ(345.28, 2341);
        assertEquals(tz.getMileage(), 345.28, 0.0001, "Mileage should be 345.28");

        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ ts = new TeslaModelZ(-0.1, 445);
        }, "Instantiating with negative mileage should throw exception");

        return getFailedCount();
    }
}
