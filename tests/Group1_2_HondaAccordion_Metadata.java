package tests;

import vehicle.*;
import bcatest.BCATestScenario;

/**
 * Group1_2_TeslaModelZ_Metadata
 */
public class Group1_2_HondaAccordion_Metadata extends BCATestScenario {

    double DELTA = .1;

    public int runTest() {
        HondaAccordian honda = new HondaAccordian(200, 2000);

        assertEquals(honda.toString(), "2000 Honda Accordian (200.0 mi)", "Invalid .toString() on Honda Accordian");
        assertEquals(honda.getFuelCapacity(), 14.5, 0, "Invalid fuel capacity for Honda Accordion");
        assertEquals(honda.getModel(), "Accordian", "Invalid model string");
        assertEquals(honda.getMPG(), 33.2, 0, "Invalid miles per gallon");
        assertEquals(honda.getRemainingRange(), 481.4, DELTA, "Invalid range for max fuel");
        return 0;
    }

}