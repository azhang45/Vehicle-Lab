package tests;

import bcatest.BCATestScenario;
import vehicle.ChevroletBird;

public class Group3_5ChevorletBirdMethods extends BCATestScenario {

    @Override
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird();

        // driving methods
        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(-1);
        }, "Driving Mileage cannot be negative");

        c1.drive(0);
        assertEquals(c1.getMileage(), 0, 0.1, "Mileage should remain 0 after driving 0 miles");
        assertEquals(c1.getRemainingRange(), 250, 0.1, "Range should remain the same after driving 0 miles");

        assertTrue(c1.canDrive(150), "CanDrive should be true");
        c1.drive(150);
        assertEquals(c1.getMileage(), 150, 0.1, "Mileage should be 150 after driving 150 miles");
        assertEquals(c1.getRemainingRange(), 100, 0.1, "Range should be 100 after driving 150 miles");

        c1.recharge();
        assertEquals(c1.getRemainingRange(), 250, 0.1, "Remaining range should be 250 after full recharge");

        c1.drive(250);
        assertEquals(c1.getMileage(), 400, 0.1, "Mileage should be 400 after driving 250 (+150) miles");
        assertEquals(c1.getRemainingRange(), 0, 0.1, "Range should be 0 after driving 250 miles");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.drive(1);
        }, "Car should not be able to drive 1 mile after driving 250");

        assertFalse(c1.canDrive(1), "CanDrive should be false");

        c1.recharge();

        // Flying methods
        assertThrows(IllegalArgumentException.class, () -> {
            c1.fly(-1);
        }, "Flying Mileage cannot be negative");

        c1.fly(0);
        assertEquals(c1.getMileage(), 400, 0.1, "Mileage should remain 400 after flying 0 miles");
        assertEquals(c1.getRemainingRange(), 250, 0.1, "Range should remain the same after flying 0 miles");

        assertTrue(c1.canFly(150), "CanFly should be true");
        c1.fly(150);
        assertEquals(c1.getMileage(), 400, 0.1,
                "Mileage should be 400 after flying 150 miles (flying does not increase mileage)");
        assertEquals(c1.getRemainingRange(), 100, 0.1, "Range should be 100 after flying 150 miles");

        c1.recharge();
        assertEquals(c1.getRemainingRange(), 250, 0.1, "Remaining range should be 250 after full recharge");

        c1.fly(250);
        assertEquals(c1.getMileage(), 400, 0.1, "Mileage should be 400 after flying 250 (+400 driven) miles");
        assertEquals(c1.getRemainingRange(), 0, 0.1, "Range should be 0 after flying 250 miles");

        assertThrows(IllegalArgumentException.class, () -> {
            c1.fly(1);
        }, "Car should not be able to fly 1 mile after flying 250");
        assertFalse(c1.canFly(1), "CanFly  should be false");

        return 0;
    }

}
