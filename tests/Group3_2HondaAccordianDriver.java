package tests;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;
import java.util.*;

public class Group3_2HondaAccordianDriver extends BCATestScenario {
    public int runTest() {
        int starting_mileage = 11;
        int modelYear = 1982; 
        // refill test
        HondaAccordian ha = new HondaAccordian(starting_mileage, modelYear);
        assertEquals(ha.getFuelCapacity(), ha.getFuelLevel(), 0.01,
                "Honda Accordian's fuel level should be at capacity in the beginning");

        ha.refillTank();
        assertEquals(ha.getFuelLevel(), 14.5, 0.001, "Fuel level when refueled should be at capacity");
        ;

        //refill (gallons) part 1, part 2 is tested after drive
        HondaAccordian honda2 = new HondaAccordian(starting_mileage, modelYear);
        assertThrows(IllegalArgumentException.class, ()->{honda2.refillTank(10);}, "Refilling a tank at capacity with 10 gallons should not be possible");

        //drive test
        assertThrows(IllegalArgumentException.class, () -> {
            ha.drive(-1);
        }, "Honda Accordian attempting to drive a negative number of miles should throw an exception");
        ha.drive(45);
        assertEquals(ha.toString(), "1982 Honda Accordian (56.0 mi)",
                "To String should show that Honda Accordian has driven 56 miles after driving 45 miles at a starting mileage of 11");

        assertEquals(ha.getFuelLevel(), ha.getFuelCapacity() - 45.0 / ha.getMPG(), 0.05,
                "The new fuel level after driving 56 miles should be the fuel capacity minus 45 / miles per gallon");

        assertThrows(IllegalArgumentException.class, () -> {
            ha.drive(481.7);
        }, "After driving less than 481.7 miles, the Honda Accordian's fuel should be barely over so 481.4 miles should throw an exception.");

        // road trip test
        ha.refillTank();
        assertEquals(ha.getFuelLevel(), 14.5, 0.001, "Fuel level when refueled should be at capacity");

        List<Double> arr = new ArrayList<>();
        arr.add(100.8);
        arr.add(200.1);
        arr.add(50.3);
        arr.add(5.2);
        arr.add(0.0);
        arr.add(300.0);
        arr.add(40.85);
        arr.add(1.01);
        int num_traveled = ha.roadTrip(arr);
        assertEquals(num_traveled, 5,
                "The honda should have travelled for only 5 days of the 8 day list on a road trip");

        //Honda Accordian roadtrip negative test
        ArrayList<Double> negativeArr = new ArrayList<>(); 
        negativeArr.add(-0.1);
        assertThrows(IllegalArgumentException.class, ()->{HondaAccordian negHonda = new HondaAccordian(11, 2389); negHonda.roadTrip(negativeArr);}, "A day in a road trip with a negative number of miles for a Honda Accordian should throw an illegal argument exception");

        //Miscellaneous Honda Accordian road trip test, where total road trip is less than maximum range of tesla
        HondaAccordian smallHonda = new HondaAccordian(5, 2017);
        ArrayList<Double> smallArr = new ArrayList<>();
        smallArr.add(2.0);
        smallArr.add(1.0);
        int smallDays = smallHonda.roadTrip(smallArr);
        assertEquals(smallDays, 2, 0.01, "For a road trip of two days (1 mile and 2 miles), the honda should be able to complete two days and return the value 2.");
        

        // can drive test
        ha.refillTank();
        boolean can_drive = ha.canDrive(481.5);
        assertFalse(can_drive, "The Honda Accordian shouldn't be able to travel more than 481.4 miles on a full tank");

        assertThrows(IllegalArgumentException.class, () -> {
            ha.canDrive(-1);
        }, "The Honda Accordian canDrive function should throw an exception upon negative miles");

        //refill test 2 after test drive has completed
        ha.drive(99.6);
        ha.refillTank(2);
        assertEquals(ha.getRemainingRange(), 448.2, 0.01, "Driving three gallons worth of miles and refilling two gallon from a full tank should result in a remaining range of 448.2 miles");

        return getFailedCount();
    }
}
