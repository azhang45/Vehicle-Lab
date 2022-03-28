package tests;

import bcatest.BCATestScenario;
import vehicle.ChevroletBird;

import java.util.ArrayList;

public class Group3_1BirdDrive extends BCATestScenario {


    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        assertThrows(IllegalArgumentException.class, () -> c1.drive(-1), "Driving mileage cannot be " + "negative.");

        assertTrue(c1.canDrive(30), "canDrive should be true");
        c1.drive(30);
        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

        assertThrows(IllegalArgumentException.class, () -> c1.drive(221), "Goes of the max charge.");


        assertEquals(c1.getRemainingRange(), 220, .1, "Remaining range should be 220.");

        assertFalse(c1.canDrive(251), "Goes over max range.");

        assertThrows(IllegalArgumentException.class, () -> c1.drive(251), "Goes over the max range");

//        assertFalse(c1.canFly(1), "Flying should fail, wings are retracted");
        c1.fly(50);
        assertTrue(c1.canFly(10), "Flying should pass, wings work.");

        assertEquals(c1.getMileage(), 30, 0.1, "Mileage has not changed");

        assertTrue(c1.checkWingsExtended(), "Wings did not extend");

        assertEquals(c1.getRemainingRange(), 170, 0.1, "Your range should be 170");

        ArrayList<Double> d2 = new ArrayList<>();
        d2.add(1.0);
        d2.add(2.0);
        d2.add(3.0);
        d2.add(99999.0);
        double x = c1.getMileage();

        assertEquals(c1.roadTrip(d2), 3, 0.1, "Should return three");
        assertEquals(c1.getMileage(), x + 6, 0.1, "Should have traveled Six miles");


        ArrayList<Double> dl = new ArrayList<>();
        dl.add(1.0);
        dl.add(2.0);
        dl.add(3.0);
        dl.add(4.0);
        dl.add(5.0);
        dl.add(-4.0);

        assertThrows(IllegalArgumentException.class, () -> c1.roadTrip(dl), "2 should go beyond maximum of the tank");

        return getFailedCount();


    }

}
