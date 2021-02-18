package com.company.tests;

import com.company.controller.DecimalCalculator;
import com.company.model.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalCalculatorTest {

    DecimalCalculator decimalCalculator = new DecimalCalculator();

    Decimal decimal1 = new Decimal(4238234098572349850234858293470982.03458234);
    Decimal decimal2 = new Decimal(348234903909.0);

    @Test
    void add() {
        assertEquals(4238234098572349850234858293470982.03458234 + 348234903909.0,
                decimalCalculator.add(decimal1, decimal2).getDecimal());
    }

    @Test
    void subtract() {
        assertEquals(4238234098572349850234858293470982.03458234 - 348234903909.0,
                decimalCalculator.subtract(decimal1, decimal2).getDecimal());
    }

    @Test
    void multiply() {
        assertEquals(4238234098572349850234858293470982.03458234 * 348234903909.0,
                decimalCalculator.multiply(decimal1, decimal2).getDecimal());
    }

    @Test
    void divide() {
        assertEquals(4238234098572349850234858293470982.03458234 / 348234903909.0,
                decimalCalculator.divide(decimal1, decimal2).getDecimal());
    }
}