package tests;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;

public class Group3_3HondaAccordianToString extends BCATestScenario{
    public int runTest() {
        
        HondaAccordian c1 = new HondaAccordian(2018); 

        assertEquals(c1.toString(), "2018 Honda Accordian (0.0 mi)", "Error in toString after creation");

        c1.drive(300);
        assertEquals(c1.toString(), "2018 Honda Accordian (300.0 mi)", "Error in toString after driving 300 miles");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(500);}, "Car should not be able to drive another 500 miles");
        assertEquals(c1.toString(), "2018 Honda Accordian (300.0 mi)", "toString should stay unaffected after the exception");

        return getFailedCount();
    }
}
