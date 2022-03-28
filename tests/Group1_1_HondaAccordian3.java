package tests;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;

public class Group1_1_HondaAccordian3 extends BCATestScenario{

    @Override
    public int runTest() {
        HondaAccordian a = new HondaAccordian(2018);

        assertEquals(a.getMPG(), 33.2, .1, "Unexpected MPG rate after instantiation");

        assertEquals(a.getFuelLevel(), 14.5, .1, "Unexpected fuel level after instantiation");

        a.drive(99.6);
        assertEquals(a.getFuelLevel(), 11.5, .1, "Unexpected fuel level after driving");

        assertThrows(IllegalArgumentException.class, () -> {a.drive(-3);}, "Exception not thrown after attempting to drive negative amount.");

        assertEquals(a.getFuelLevel(), 11.5, .1, "Unexpected fuel level after recovering from exception"); //might be a bit repetitive

        a.refillTank();
        assertEquals(a.getFuelLevel(), 14.5, .1, "Unexpected fuel level after tank refill");

        assertEquals(a.getFuelCapacity(), 14.5, .1, "Unexpected fuel capacity level after refill");

        a.drive(448.2);
        assertEquals(a.getFuelLevel(), 1.0, .1, "Unexpected fuel level after driving");

        assertEquals(a.getRemainingRange(), 33.2, .1, "Unexpected remaining range after driving");

        return getFailedCount();
    }
}
