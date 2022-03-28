package tests;

import java.util.ArrayList;
import java.util.List;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;
import vehicle.HondaAccordian;

public class Group1_3_GasPoweredCreation extends BCATestScenario {

    @Override
    public int runTest() {
        HondaAccordian c1 = new HondaAccordian(2018);

        assertEquals(c1.toString(), "2018 Honda Accordian (0.0 mi)", "toString does not match");

        assertEquals(c1.getMPG(), 33.2, .1, "Initial mpg not correct." );

        assertEquals(c1.getFuelCapacity(), 14.5, .1, "Initial fuel capacity not correct." );

        assertEquals(c1.getFuelLevel(), 14.5, .1, "Initial fuel level not correct." );

        assertEquals(c1.getRemainingRange(), c1.getFuelLevel() * c1.getMPG(), .1, "Remaining range of car not correct at creation.");

        FordFrivolous c2 = new FordFrivolous();

        assertEquals(c2.toString(), "Ford Frivolous (0.0 mi)", "toString does not match");

        List<Double> milesEachDay1 = new ArrayList<Double>();
        milesEachDay1.add(-1.0);
        assertThrows(IllegalArgumentException.class, () -> {c2.roadTrip(milesEachDay1);}, "Cannot drive negative miles for any day");

        List<Double> milesEachDay2 = new ArrayList<Double>();
        milesEachDay2.add(5.0);
        milesEachDay2.add(0.0);
        milesEachDay2.add(20.0);
        milesEachDay2.add(16.4);
        assertEquals(c2.roadTrip(milesEachDay2), 4, "Days do not match");

        assertEquals(c2.getRemainingRange(), 430.6, .1, "Remaining range of car not correct at creation.");

        List<Double> milesEachDay3 = new ArrayList<Double>();
        milesEachDay3.add(50.0);
        milesEachDay3.add(50.0);
        milesEachDay3.add(50.0);
        milesEachDay3.add(50.0);
        assertEquals(c2.roadTrip(milesEachDay3), 4, "Days do not match");

        assertEquals(c2.getMake(), "Ford", "Make not correct." );

        assertEquals(c2.getModel(), "Frivolous", "Model not correct." );

        return getFailedCount();
    }
}
