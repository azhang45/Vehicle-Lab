package tests;
import java.util.ArrayList;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_6FordFriv_Roadtrip extends BCATestScenario {
    public int runTest() {
        FordFrivolous c1 = new FordFrivolous(2000);
        
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(400.0);
        list1.add(70.0);
        list1.add(2.0);
        list1.add(1.0);
        
        
        assertEquals(c1.roadTrip(list1), 3, "Car should drive for 3 days.");
        assertEquals(c1.getFuelLevel(), 0, .1, "Car should have an empty fuel tank");


        c1.refillTank();

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(400.0);
        list2.add(70.0);
        list2.add(-2.0);

        assertThrows(IllegalArgumentException.class, () -> {
            c1.roadTrip(list2);
        }, "Roadtrip cannot run if there is a negative mile element.");

        c1.refillTank();
        ArrayList<Double> list3 = new ArrayList<>();
        list3.add(450.0);
        assertEquals(c1.roadTrip(list3), 1, "Car should drive for 1 day.");

        

      

        return getFailedCount();
    }
}
