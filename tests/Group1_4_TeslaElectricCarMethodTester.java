package tests;

import vehicle.TeslaModelZ;
import bcatest.BCATestScenario;

public class Group1_4_TeslaElectricCarMethodTester extends BCATestScenario {

    public int runTest() {
        TeslaModelZ t1 = new TeslaModelZ(0, 60);
        t1.drive(0);
        assertEquals(t1.getMileage(), 0.0, .1, "mileage should be 0");
        t1.drive(100);
        assertEquals(t1.getMileage(), 100.0, .1, "mileage should be 100" );
        assertThrows(IllegalArgumentException.class, () -> {t1.drive(-1);}, "TeslaModelZ should not be able to drive negative distance");
        assertThrows(IllegalArgumentException.class, () -> {t1.drive(500);}, "TeslaModelZ should not be able to drive above its possible mileage");
        assertEquals(t1.getRemainingRange(), 240.0, .1, "remaining range should be 240" );
        assertEquals(t1.getMaxRange(), 340.0, .1, "range on full charge should be 340" );
        t1.recharge();
        assertEquals(t1.getRemainingRange(), 340.0, .1, "remaining range should be updated to 340" );
        assertEquals(t1.getMileage(), 100.0, .1, "mileage should be 100" );
        t1.drive(t1.getRemainingRange());
        assertEquals(t1.getRemainingRange(), 0.0, .1, "remaining range should be now be 0" );
        

        return getFailedCount();
    }
}
