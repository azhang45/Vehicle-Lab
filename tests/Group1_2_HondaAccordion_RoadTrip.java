package tests;

import vehicle.*;

import java.util.Arrays;

import bcatest.BCATestScenario;

public class Group1_2_HondaAccordion_RoadTrip extends BCATestScenario {

    double DELTA = .1;

    @Override
    public int runTest() {
        var honda = new HondaAccordian(200, 2000);
        assertEquals(honda.roadTrip(Arrays.asList(new Double[] { 20.0, 40.0, 50.0, 60.0, 10.0, 30.0, 150.0 })), 7.0,
                DELTA, "Not expected roadtrip distance");
        honda.refillTank();
        assertEquals(honda.getFuelLevel(), 14.5, 0.01, "Refueling did not work in roadtrip");
        assertEquals(honda.roadTrip(Arrays.asList(new Double[] { 20.0, 40.0, 50.0, 60.0, 131.4, 30.0, 150.0 })), 7.0,
                DELTA, "Not expected roadtrip distance, failed max drive");
        honda.refillTank();
        assertEquals(
                honda.roadTrip(
                        Arrays.asList(new Double[] { 20.0, 40.0, 50.0, 60.0, 10.0, 30.0, 150.0, 20.0, 10.0, 5.0 })),
                10.0, DELTA, "Not expected roadtrip distance");
        assertEquals(honda.roadTrip(Arrays.asList(new Double[] { 0.0 })), 1.0, DELTA, "Test");

        return getFailedCount();
    }
}