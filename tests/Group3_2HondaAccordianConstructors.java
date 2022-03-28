package tests;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;

public class Group3_2HondaAccordianConstructors extends BCATestScenario {
    public int runTest() {
        HondaAccordian ha = new HondaAccordian(2025);
        assertEquals(ha.getMileage(), 0.0, 0.0001, "When instantiated with only year, starting mileage should be 0");
        assertEquals(ha.toString(), "2025 Honda Accordian (0.0 mi)",
                "To string for honda accordian not working for 1 arg constructor");
        assertEquals(ha.getMPG(), 33.2, 0.0001, "MPG of Honda Accordian with 1 arg constructor should be 33.2");
        assertEquals(ha.getFuelCapacity(), 14.5, 0.0001,
                "Fuel capacity of Honda Accordian with 1 arg constructor should be 14.5 gallons");
        assertEquals(ha.getMake(), "Honda", "The make of a Honda Accordion should be Honda");

        ha = new HondaAccordian(14.28, 15);
        assertEquals(ha.getMileage(), 14.28, 0.0001, "Starting mileage not being instantiated with the correct value");
        assertThrows(IllegalArgumentException.class, () -> {
            HondaAccordian hn = new HondaAccordian(-0.1, 445);
        }, "Instantiating with negative mileage should throw exception");

        return getFailedCount();
    }
}
