package tests;

import java.util.Arrays;
import java.util.List;

import bcatest.BCATestScenario;
import vehicle.TeslaModelZ;

public class Group1_2_TeslaModelZ_RoadTrip extends BCATestScenario {

    double DELTA = .1;

    @Override
    public int runTest() {
        assertEquals(
                new TeslaModelZ(1)
                        .roadTrip(Arrays.asList(
                                new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 })),
                6,
                "Tesla should be able to drive all 6 days.");

        assertEquals(
                new TeslaModelZ(1)
                        .roadTrip(Arrays.asList(
                                new Double[] { 100.0, 200.0, 30.0, 40.0, 5.0, 6.0 })),
                3,
                "Tesla should be able to drive exactly 3 days.");

        var tempTesla0 = new TeslaModelZ(1);

        assertThrows(
                IllegalArgumentException.class,
                () -> tempTesla0.roadTrip(Arrays.asList(
                        new Double[] { 10.0, 20.0, 30.0, 40.0, 50.0, 60.0, -1.0 })),
                "Tesla should throw exception when a road trip includes a negative mile day.");

        assertEquals(
                tempTesla0.getRemainingRange(),
                340.0,
                DELTA,
                "Tesla should be throw exception BEFORE driving any miles.");

        return getFailedCount();
    }

}