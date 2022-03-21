package tests;

import bcatest.BCATestScenario;
import vehicle.TeslaModelZ;

public class Group3_6TeslaModelZ_SelfDriving extends BCATestScenario {

    @Override
    public int runTest() {
        TeslaModelZ c1 = new TeslaModelZ(50);
        assertThrows(IllegalArgumentException.class, () -> {
            c1.driveAutonomously(-0.1);
        }, "Driving mileage cannot be negative.");

        c1.driveAutonomously(0);
        assertEquals(c1.getMileage(), 0, .1, "Mileage should be 0 after first drive.");

        c1.driveAutonomously(30);
        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after second drive.");

        c1.driveAutonomously(200);
        assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after third drive.");

        assertEquals(c1.getRemainingRange(), c1.getMaxRange() - 230, .1,
                "Remaining range of car not correct after driving three times.");

        c1.recharge();
        assertEquals(c1.getRemainingRange(), c1.getMaxRange(), .1,
                "Remaining range of car not correct after recharging.");

        c1.driveAutonomously(340);
        assertEquals(c1.getMileage(), 570, .1, "Mileage should be 570 after fourth drive.");

        assertEquals(c1.getRemainingRange(), c1.getMaxRange() - 340, .1,
                "Remaining range of car not correct after driving four times.");

        c1.driveAutonomously(341);
        assertEquals(c1.getMileage(), 570, .1, "Mileage should be 570 after fifth drive.");

        assertEquals(c1.getRemainingRange(), c1.getMaxRange() - 340, .1,
                "Remaining range of car not correct after driving five times.");

        return 0;
    }

}
