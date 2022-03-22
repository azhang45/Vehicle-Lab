package tests;
import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_6FordFriv_ArgConstructors extends BCATestScenario {
    public int runTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            FordFrivolous f1 = new FordFrivolous(-1);
        }, "Starting mileage cannot be negative.");

        FordFrivolous f2 = new FordFrivolous(10);
        

        assertEquals(f2.getMileage(), 10, .1, "Mileage is incorrect (at creation)");

       
        assertEquals(f2.getMPG(),23.6, 0.1, "MPG is incorrect (at creation)");

        assertEquals(f2.getFuelCapacity(), 20, 0.1, "Fuel capacity is incorrect (at creation)");

        assertEquals(f2.getFuelLevel(), 20, 0.1, "Fuel level is incorrect (at creation)");
       

        assertEquals(f2.getRemainingRange(), 472, .1, "Remaining range of car not correct (at creation).");

        assertEquals(f2.toString(), "Ford Frivolous (10.0 mi)", "toString does not match");

        return getFailedCount();
    }
}
