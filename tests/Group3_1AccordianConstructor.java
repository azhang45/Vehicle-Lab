package tests;

import bcatest.BCATestScenario;
import vehicle.HondaAccordian;

public class Group3_1AccordianConstructor extends BCATestScenario {


    public int runTest() {

        // assertThrows(IllegalArgumentException.class, () -> new HondaAccordian(1885), "Attemped to " +
        //         "create a car with the year 1885, but not exception was thrown. Year must be at least 1886, since " +
        //         "that's when cars were invented!");

        assertThrows(IllegalArgumentException.class, () -> new HondaAccordian(-1.0, 1999),
                "Attemped to create a car with starting mileage -1.0 and year 1999, but no exception was " +
                        "thrown for negative mileage.");

        HondaAccordian c1 = new HondaAccordian(0, 2000);
        assertEquals(c1.getMileage(), 0, .1, String.format("Mileage should be zero, not %.1f",
                c1.getMileage()));
        assertEquals(c1.getMPG(), 33.2, 0.1, "The MPG should be 33.2");
        assertEquals(c1.getFuelLevel(), 14.5, 0.1, ("fuel level for honda accordian upon creation " +
                "should be 14.5, not " + c1.getFuelLevel()));
        assertEquals(c1.toString(), "2000 Honda Accordian (0.0 mi)", "toString expected [2000" +
                " Honda Accordian (0.0 mi)], but got [" + c1 + "]");
        assertEquals(c1.getRemainingRange(), 481.4, 0.1, "Remaining range upon creattion " +
                "should be 481.4 " + c1.getRemainingRange());
        assertEquals(c1.getMake(), "Honda", "The make should be Honda, not " + c1.getMake());
        assertEquals(c1.getModel(), "Accordian", "the model should be Accordian, not " +
                c1.getModel());
        return getFailedCount();
    }
}