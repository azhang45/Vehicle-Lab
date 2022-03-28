package tests;

import bcatest.BCATestScenario;
import vehicle.FordFrivolous;

public class Group3_3FordFrivolousFuel extends BCATestScenario{
    public int runTest() {

        FordFrivolous c1 = new FordFrivolous();
        
        assertEquals(c1.getMPG(), 23.6, .1, "Default MPG should be 23.6");

        assertEquals(c1.getFuelLevel(), 20.0, .1, "Iniitial fuel level should be 20.0");

        assertEquals(c1.getFuelCapacity(), 20.0, .1, "Max Fuel Capacity for this car should be 20.0");

        assertEquals(c1.getRemainingRange(), 472.0, .1, "The initial remaining range should be 472.0");

        // drive(-1) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "You cannot drive a negative distance");
        // drive(473) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(473);}, "You cannot drive more than the max fuel capacity");

        c1.drive(236);

        assertEquals(c1.getRemainingRange(), 236.0, .1, "Remaining Range should be 236");

        assertEquals(c1.getMileage(), 236.0, .1, "Mileage should be 236.0 since that is the distance we have driven so far");

        assertEquals(c1.getRemainingRange(), 236.0, .1, "Remaining Range should be 236");

        // refillTank(237) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(20.1);}, "You can not fill the tank to more than 20 gallons");
        // refillTank(-1) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(-1);}, "You can not fill the tank with negative gallons");

        c1.refillTank(5);

        assertEquals(c1.getFuelLevel(), 15.0, .1, "Gallons left in the tank should be 15");

        assertEquals(c1.getRemainingRange(), 354.0, .1, "The remaining range based on our fuel level should be 354");

        





        return getFailedCount();
    }
}
