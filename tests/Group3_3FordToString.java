package tests;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_3FordToString extends BCATestScenario {
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous();

        assertEquals(c1.toString(), "Ford Frivolous (0.0 mi)", "Error in toString");

        c1.drive(472);
        assertEquals(c1.toString(), "Ford Frivolous (472.0 mi)", "Error in toString after driving 472 miles");

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(472);}, "Car should not be able to drive another 500 miles");
        assertEquals(c1.toString(), "Ford Frivolous (472.0 mi)", "toString should stay unaffected after the exception");

        return getFailedCount();

    }
    
}
