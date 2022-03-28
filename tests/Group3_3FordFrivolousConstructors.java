package tests;
import bcatest.BCATestScenario;
import vehicle.FordFrivolous;


public class Group3_3FordFrivolousConstructors extends BCATestScenario{
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous();

        assertEquals(c1.getMileage(), 0, .1, "Default mileage should be zero.");

        assertEquals(c1.getFuelCapacity(), 20.0, .1, "Initial fuel capacity not correct." );

        assertEquals(c1.getFuelCapacity(), c1.getFuelLevel(), .1, "The car should begin full.");

        assertEquals(c1.getMPG(), 23.6, .1, "Initial mpg not correct." );

        assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG(), .1, "Remaining range of car not correct at creation.");

        assertEquals(c1.toString(), "Ford Frivolous (0.0 mi)", "toString does not match");


        return getFailedCount();
    }
}
