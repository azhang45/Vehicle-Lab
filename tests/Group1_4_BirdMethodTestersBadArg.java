package tests;

import vehicle.ChevroletBird;
import bcatest.BCATestScenario;

public class Group1_4_BirdMethodTestersBadArg extends BCATestScenario {
    public int runTest() {
        assertThrows(IllegalArgumentException.class, () -> {new ChevroletBird(-100);}, "Cannot create a Bird object with negative starting mileage");
        return getFailedCount();
    }
}

