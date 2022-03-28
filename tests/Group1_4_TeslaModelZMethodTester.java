package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

public class Group1_4_TeslaModelZMethodTester extends BCATestScenario {

    public int runTest() {
        assertThrows(IllegalArgumentException.class, () -> {new TeslaModelZ(-100, 60);}, "cannot create a Tesla object with negative starting mileage");
        TeslaModelZ t1 = new TeslaModelZ(60);
        assertEquals(t1.getModelNum(), 60, "modelNum should be 60.");
        assertEquals(t1.getModel(), "Z60", "model should be Z60" );
        t1.driveAutonomously(200);
        assertEquals(t1.getMileage(), 200.0, .1, "mileage should be 200" );
        t1.driveAutonomously(0);
        assertEquals(t1.getMileage(), 200.0, .1, "mileage should remain the same if Tesla autonously drives no distance" );
        assertThrows(IllegalArgumentException.class, () -> {t1.driveAutonomously(-1);}, "TeslaModelZ should not be able to autonomously drive negative distance");
        t1.driveAutonomously(500);
        assertEquals(t1.toString(), "Tesla Z60 (340.0 mi)", "toString does not match");
        
        return getFailedCount();
    }
}
