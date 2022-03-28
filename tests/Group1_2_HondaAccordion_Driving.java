package tests;

import vehicle.*;
import bcatest.BCATestScenario;

/**
 * Group1_2_TeslaModelZ_Metadata
 */
public class Group1_2_HondaAccordion_Driving extends BCATestScenario {

    double DELTA = .1;

    public int runTest() {
        assertThrows(IllegalArgumentException.class, () -> new HondaAccordian(-1, 1949),
                "Honda should not be able to have negative mileage");

        HondaAccordian honda = new HondaAccordian(200, 2000);
        honda.drive(166);
        assertEquals(honda.getRemainingRange(), 14.5 * 33.2 - 166, DELTA, "Invalid remaining range");
        assertEquals(honda.getFuelLevel(), 9.5, DELTA, "Invalid fuel level");
        assertThrows(IllegalArgumentException.class, () -> honda.drive(315.41),
                "Honda should not be able to drive 315.41");
        honda.drive(315.4);
        assertEquals(honda.getMileage(), 200 + 14.5 * 33.2, DELTA, "Mileage does not increment correctly");
        return 0;
    }

}