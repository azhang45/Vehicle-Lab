package tests;

import bcatest.BCATestScenario;
import vehicle.HondaAccordian;

public class Group3_6Honda_Accordian_Constructor extends BCATestScenario {


    public int runTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            HondaAccordian h = new HondaAccordian(1885);
        }, "Year must be at least 1886");

        assertThrows(IllegalArgumentException.class, () -> {
            HondaAccordian h = new HondaAccordian(-1.0, 1999);
        }, "You can't have a negative starting mileage");

        HondaAccordian c1 = new HondaAccordian(0, 2000);
        assertEquals(c1.getMileage(), 0, .1, "Mileage should be zero");
        assertEquals(c1.getMPG(), 33.2, 0.1, "The MPG should be 33.2");
        assertEquals(c1.getFuelLevel(), 14.5, 0.1, "The fuel level should be 14.5");
        assertEquals(c1.toString(), "2000 Honda Accordian (0 mi)", "These should be equal");
        assertEquals(c1.getRemainingRange(), 481.4, 0.1, "Remaining range should be 481.4");
        assertEquals(c1.getMake(), "Honda", "The make should be Honda");
        assertEquals(c1.getModel(), "ACcordian", "the model should be Accordian");

        return getFailedCount();
    }
}