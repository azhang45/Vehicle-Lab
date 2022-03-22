package tests;
import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_6FordFriv_NoArgConstructor extends BCATestScenario{
    public int runTest() {

        //no-arg constructor
        FordFrivolous f3 = new FordFrivolous();
        assertEquals(f3.getMileage(), 0, 0, "Mileage is incorrect (at creation)");

       
        assertEquals(f3.getMPG(),23.6, 0.1, "MPG is incorrect (at creation)");

        assertEquals(f3.getFuelCapacity(), 20, 0.1, "Fuel capacity is incorrect (at creation)");

        assertEquals(f3.getFuelLevel(), 20, 0.1, "Fuel level is incorrect (at creation)");
       

        assertEquals(f3.getRemainingRange(), 472, .1, "Remaining range of car not correct (at creation).");

        assertEquals(f3.toString(), "Ford Frivolous (0.0 mi)", "toString does not match");

        



        return getFailedCount();
    }
}
