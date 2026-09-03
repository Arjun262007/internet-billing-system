package com.billing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillingSystemTest {

    @Test
    public void testBasicPlanWithinLimit() {
        assertEquals(30.0, BillingSystem.calculateBill("basic", 40.0), 0.01);
    }

    @Test
    public void testBasicPlanExceedingLimit() {
        // 50GB limit + 10GB extra @ $1.00/GB = $40.00
        assertEquals(40.0, BillingSystem.calculateBill("basic", 60.0), 0.01);
    }

    @Test
    public void testPremiumPlanExceedingLimit() {
        // 200GB limit + 20GB extra @ $0.50/GB = $90.00
        assertEquals(90.0, BillingSystem.calculateBill("premium", 220.0), 0.01);
    }
}
