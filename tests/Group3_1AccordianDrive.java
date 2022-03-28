package tests;

import bcatest.BCATestScenario;
import vehicle.HondaAccordian;

import java.util.ArrayList;

public class Group3_1AccordianDrive extends BCATestScenario {

    @Override
    public int runTest() {
        HondaAccordian h = new HondaAccordian(0, 2018);

        assertThrows(IllegalArgumentException.class, () -> h.drive(-1), "Attemped to drive -1 miles," +
                " but no exception was thrown.");
        h.drive(0);
        assertEquals(h.getMileage(), 0, 0.1, "Attempted to drive 0 miles, but the mileage " +
                "went up.");
        h.drive(33.2);
        assertEquals(h.getMileage(), 33.2, 0.1, "Mileage should be equal to 33.2 after " +
                "driving 33.2 miles");
        assertEquals(h.getFuelLevel(), h.getFuelCapacity() - 1, 0.01, ("Fuel level should be 13.5 " +
                "gallons after driving 33.2 miles, not " + h.getFuelCapacity()));
        assertThrows(IllegalArgumentException.class, () -> h.refillTank(-1), "Attempted to fill " +
                "up tank with -1 gallons, no exception was thrown.");
        assertThrows(IllegalArgumentException.class, () -> h.refillTank(2), "Attempted to refill " +
                "tank with gas that would cause tank overflow, but no exception was thrown.");
        h.refillTank();
        assertEquals(h.getFuelLevel(), h.getFuelCapacity(), 0.1, ("Refilled tank, fuelCapacity should be at " +
                "14.5, not " + h.getFuelCapacity()));
        h.drive(66.4);
        h.refillTank(2);
        assertEquals(h.getFuelLevel(), h.getFuelCapacity(), 0.1, ("Refilled tank, fuelCapacity should be at " +
                "14.5, not " + h.getFuelCapacity()));
        ArrayList<Double> dl = new ArrayList<>();
        dl.add(1.0);
        dl.add(2.0);
        dl.add(3.0);
        dl.add(4.0);
        dl.add(5.0);
        dl.add(-4.0);

        assertThrows(IllegalArgumentException.class, () -> h.roadTrip(dl), "Negative amount of miles in " +
                "the last index of the road trip to drive, but no exception was thrown.");

        dl.remove(-4.0);
        dl.remove(5.0);
        dl.remove(4.0);
        dl.add(99999.0);
        double x = h.getMileage();

        assertEquals(h.roadTrip(dl), 3, 0.1, "Attemped to go on road trip where 4th distance" +
                " to drive was too long, but return value was not 3.");
        assertEquals(h.getMileage(), x + 6, 0.1, ("Should have traveled 1,2,3 miles, increasing mileage" +
                " by 6, not by " + (h.getMileage() - x)));

        return getFailedCount();
    }

}
