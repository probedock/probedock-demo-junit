package io.probedock.demo.junit;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Combined multiple operations at the same time
 */
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tickets = { "feature-1", "feature-2", "feature-3", "feature-4" }, tags = "mixed")
public class MixedOperationsTest {
    @Test
    public void itShouldBePossibleToMixDifferentOperations() {
        assertEquals(5, new OperationDiv(new OperationAdd(20, new OperationSub(0, 10)), new OperationMul(1, 2)).process());
    }

    @Test
    @ProbeTest(name = "This operation should be correct: (6 + 30) - (2 * (15 / 5)) = 30")
    public void itShouldReturnTheCorrectResult() {
        assertEquals(30, new OperationSub(new OperationAdd(6, 30), new OperationMul(2, new OperationDiv(15, 5))).process());
    }

    @Test
    @ProbeTest
    public void itShouldNotBePossibleToProcessTheOperationsIfDeepDivisionOperationHasRightOperandEqualToZero() {
        try {
            // 5 + (5 - (5 / (5 * (5 + (10 - 15)))))
            new OperationAdd(5, new OperationSub(5, new OperationDiv(5, new OperationMul(5, new OperationAdd(5, new OperationSub(10, 15))))).process());
            fail("It should raise an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }
}
