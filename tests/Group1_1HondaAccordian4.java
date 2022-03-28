package tests;

import java.util.List;

import bcatest.BCATestScenario;

import vehicle.HondaAccordian;

public class Group1_1HondaAccordian4 extends BCATestScenario{

    @Override
    public int runTest() {
        HondaAccordian h = new HondaAccordian(2.0, 2018);


        assertEquals(h.getMake(), "Honda", "Unexpected make after instantiation");

        assertEquals(h.getModel(), "Accordian", "Unexpected model after instantiation");

        assertEquals(h.getMileage(), 2.0, .1, "Unexpected mileage after instantiation");

        h.drive(30.0);
        assertEquals(h.getMileage(), 32.0, .1, "Unexpected mileage after driving");

        assertEquals(h.toString(), "2018 Honda Accordian (32.0 mi)", "Unexpected toString return value");

        assertEquals(h.getRemainingRange(), 451.4, .1, "Unexpected remaining range after driving");

        List<Double> list = List.of(20.2, 20.0, 20.0);
        assertEquals(h.roadTrip(list), 3, .1, "Unexpected # of days in road trip");

        assertEquals(h.toString(), "2018 Honda Accordian (92.2 mi)", "Unexpected toString return value after road trip");

        List<Double> list2 = List.of(20.2, -20.0, 20.0);
        assertThrows(IllegalArgumentException.class, () -> {h.roadTrip(list2);}, "Exception not thrown when attempting to drive negative amount in road trip");

        assertEquals(h.getMileage(), 92.2, .1, "Unexpected mileage amount after recovering from exception");

        // starting 481.4
        h.drive(371.2);
        // 80.006
        assertEquals(h.getRemainingRange(), 20, .1, "Unexpected remaining range after driving");
        List<Double> list3 = List.of(5.0, 20.0, 10.0);
        assertEquals(h.roadTrip(list3), 1, .1, "Unexpected # of days in road trip");
        assertEquals(h.getMileage(), 468.4, .1, "Unexpected mileage amount after recovering from exception");

        return getFailedCount();
    }
    
}
