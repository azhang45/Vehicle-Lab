package tests;

import bcatest.BCATestScenario;
import vehicle.HondaAccordian;

public class Group3_3HondaAccordianConstructors extends BCATestScenario{
    public int runTest() {
        HondaAccordian c1 = new HondaAccordian(2018);

        assertEquals(c1.getMileage(), 0, .1, "Default mileage should be zero.");

        assertEquals(c1.getFuelCapacity(), 14.5, .1, "Initial fuel capacity not correct." );

        assertEquals(c1.getFuelCapacity(), c1.getFuelLevel(), .1, "The car should begin full.");

        assertEquals(c1.getMPG(), 33.2, .1, "Initial mpg not correct." );

        assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG(), .1, "Remaining range of car not correct at creation.");

        assertEquals(c1.toString(), "2018 Honda Accordian (0.0 mi)", "toString does not match");


        return getFailedCount();
    }
}
