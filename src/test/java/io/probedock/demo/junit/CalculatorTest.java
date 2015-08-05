package io.probedock.demo.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Test for class {@link Calculator}
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void onePlusThreeShouldEqualFour() {
        assertEquals(4, calculator.add(1, 3));
    }
}
