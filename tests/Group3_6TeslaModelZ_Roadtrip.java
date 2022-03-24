package tests;
import java.util.ArrayList;

import bcatest.BCATestScenario;
import vehicle.TeslaModelZ;

public class Group3_6TeslaModelZ_Roadtrip extends BCATestScenario{
    public int runTest() {
        TeslaModelZ c1 = new TeslaModelZ(5);
        
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(300.0);
        list1.add(30.0);
        list1.add(3.0);
        list1.add(5.0);
        list1.add(3.0);
        
        
        assertEquals(c1.roadTrip(list1), 4, "Car should drive for 4 days.");
        assertEquals(c1.getRemainingRange(), 2.0, .1, "Remaining range should be 2.0");
      


        c1.recharge();

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(300.0);
        list2.add(30.0);
        list2.add(-2.0);
        list2.add(5.0);

        assertThrows(IllegalArgumentException.class, () -> {
            c1.roadTrip(list2);
        }, "Roadtrip cannot run if there is a negative mile element.");

        c1.recharge();

        ArrayList<Double> list3 = new ArrayList<>();
        list3.add(330.0);
        assertEquals(c1.roadTrip(list3), 1, "Car should drive for 1 day.");

      

        return getFailedCount();
    }
}
