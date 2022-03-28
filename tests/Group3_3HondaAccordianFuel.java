package tests;

import bcatest.BCATestScenario;

import vehicle.HondaAccordian;

public class Group3_3HondaAccordianFuel extends BCATestScenario {
    public int runTest() {

        HondaAccordian c1 = new HondaAccordian(2018);
        
        assertEquals(c1.getMPG(), 33.2, .1, "Default MPG should be 33.2");

        assertEquals(c1.getFuelLevel(), 14.5, .1, "Iniitial fuel level should be 14.5");

        assertEquals(c1.getFuelCapacity(), 14.5, .1, "Max Fuel Capacity for this car should be 14.5");

        assertEquals(c1.getRemainingRange(), 481.4, .1, "The initial remaining range should be 481.4");

        // drive(-1) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1);}, "You cannot drive a negative distance");
        // drive(473) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.drive(482);}, "You cannot drive more than the max fuel capacity");

        c1.drive(240.7);

        assertEquals(c1.getRemainingRange(), 240.7, .1, "Remaining Range should be 240.7");

        assertEquals(c1.getMileage(), 240.7, .1, "Mileage should be 240.7 since that is the distance we have driven so far");

        assertEquals(c1.getRemainingRange(), 240.7, .1, "Remaining Range should be 240.7");

        // refillTank(237) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(14.6);}, "You can not fill the tank to more than 14.5 gallons");
        // refillTank(-1) should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(-1);}, "You can not fill the tank with negative gallons");

        c1.refillTank(2.75);

        assertEquals(c1.getFuelLevel(), 10.0, .1, "Gallons left in the tank should be 10");

        assertEquals(c1.getRemainingRange(), 332.0, .1, "The remaining range shold be ");

        





        return getFailedCount();
    }
}
