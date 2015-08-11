package io.probedock.demo.junit;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import io.probedock.rt.client.junit.ProbeDockRTBlockJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Test for class {@link OperationDiv}
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@RunWith(ProbeDockRTBlockJUnit4ClassRunner.class)
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tags = "div", tickets = "feature-4")
public class OperationDivTest {
    @Test
    @ProbeTest(tags = "calculate")
    public void theDivisionOfTwoIntegerThroughCalculateShouldBeCorrect() {
        assertEquals(5, new OperationDiv(10, 2).calculate());
    }

    @Test
    @ProbeTest(tags = "process")
    public void theDivisionOfTwoIntegerThroughProcessShouldBeCorrect() {
        assertEquals(5, new OperationDiv(10, 2).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "process" })
    public void theResultOfDivisionOfTwoIntegerShouldBeTheSameForProcessAndCalculate() {
        assertEquals(new OperationDiv(10, 2).process(), new OperationDiv(10, 2).calculate());
    }

    @Test
    @ProbeTest(tags = { "calculate", "error" })
    public void itShouldNotBePossibleToDivideByZeroThroughCalculate() {
        try {
            new OperationDiv(10, 0).calculate();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }

    @Test
    @ProbeTest(tags = { "process", "error" })
    public void itShouldNotBePossibleToDivideByZeroThroughProcess() {
        try {
            new OperationDiv(10, 0).process();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessDivisionWithLeftIntegerAndRightOperation() {
        assertEquals(5, new OperationDiv(10, new OperationDiv(2, 1)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed", "error" })
    public void itShouldNotBePossibleUseCalculateWhenLeftIsIntegerAndRightIsAlsoOperation() {
        try {
            new OperationDiv(10, new OperationDiv(2, 1)).calculate();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }

    @Test
    @ProbeTest(tags = { "process", "composed", "error" })
    public void itShouldNotBePossibleToDivideByZeroThroughProcessWhenLeftIsIntegerAndRightIsOperation() {
        try {
            new OperationDiv(10, new OperationSub(3, 3)).process();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessDivisionWithLeftOperationAndRightInteger() {
        assertEquals(5, new OperationDiv(new OperationDiv(20, 2), 2).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsInteger() {
        assertNotEquals(5, new OperationDiv(new OperationDiv(20, 2), 2).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed", "error" })
    public void itShouldNotBePossibleToDivideByZeroThroughProcessWhenLeftIsOperationndRightIsInteger() {
        try {
            new OperationDiv(new OperationDiv(10, 2), 0).process();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessDivisionWithLeftOperationAndRightAlso() {
        assertEquals(5, new OperationDiv(new OperationDiv(20, 2), new OperationDiv(4, 2)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed", "error" })
    public void itShouldNotBePossibleUseCalculateWhenLeftIsOperationAndRightIsAlsoOperation() {
        try {
            new OperationDiv(new OperationDiv(20, 2), new OperationDiv(4, 2)).calculate();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }

    @Test
    @ProbeTest(tags = { "process", "composed", "error" })
    public void itShouldNotBePossibleToDivideByZeroThroughProcessWhenLeftIsOperationndRightIsOperation() {
        try {
            new OperationDiv(new OperationDiv(10, 2), new OperationSub(5, 5)).process();
            fail("It should throw an IllegalStateException");
        }
        catch (IllegalStateException ise) {
            assertEquals("Cannot divide by zero.", ise.getMessage());
        }
    }
}
