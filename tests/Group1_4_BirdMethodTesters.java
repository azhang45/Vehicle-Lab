package tests;
import vehicle.ChevroletBird;
import java.util.Arrays;
import java.util.List;
import bcatest.BCATestScenario;

public class Group1_4_BirdMethodTesters extends BCATestScenario {

    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        List<Double> list1 = Arrays.asList(600.0, 200.0, 200.0);
        List<Double> list2 = Arrays.asList(5.0, 2.0, 1.0);
        List<Double> list3 = Arrays.asList(50.0, 20.0, -10.0);
        List<Double> list4 = Arrays.asList(50.0, 20.0, 2500.0);

        assertFalse(c1.canDrive(3000), "Should not be able to drive miles that are greater than range");
        assertThrows(IllegalArgumentException.class, ()->{c1.canDrive(-100);}, "Should throw exception if miles are negative");
        assertTrue(c1.canDrive(10), "Should be able to drive 10 miles");
        assertTrue(c1.canDrive(0), "Should be able to drive 0 miles");
        assertEquals(c1.getMileage(), 0, .1, "Default mileage should be zero.");
        assertEquals(c1.getRemainingRange(), 250, .1, "Remaining range is not correct." );
        assertEquals(c1.getMaxRange(), 250, .1, "The car should have a max range of 250 miles..");
        assertEquals(c1.toString(), "Chevrolet Bird (0.0 mi)", "toString does not match");
        assertEquals(c1.roadTrip(list1), 0, "Bird should not be able to drive 600 miles on the first day");
        assertEquals(c1.getRemainingRange(), c1.getMaxRange(), .1, "Range should not have changed since bird did not drive");
        assertEquals(c1.roadTrip(list2), 3, "Bird should be able to drive all three days successfully");
        assertEquals(c1.getRemainingRange(), c1.getMaxRange() - 5.0 - 2.0 - 1.0, .1, "Gas incorrectly deducted from road trip after driving 3 days");
        c1.recharge();
        assertThrows(IllegalArgumentException.class, ()->{c1.roadTrip(list3);}, "Bird should throw an error due to negative range within list");
        assertEquals(c1.getRemainingRange(), 250, .1, "Range should not have decreased as there was negative distance in list");
        c1.recharge();
        assertEquals(c1.roadTrip(list4), 2, "Bird should not be able drive all three days as third is too large");
        
        return getFailedCount();
    }
}
