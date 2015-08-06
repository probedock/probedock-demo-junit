package io.probedock.demo.junit;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test for class {@link OperationSub}
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tags = "sub", tickets = "feature-2")
public class OperationSubTest {
    @Test
    @ProbeTest(tags = "calculate")
    public void theSubtractionOfTwoIntegerThroughCalculateShouldBeCorrect() {
        assertEquals(2, new OperationSub(3, 1).calculate());
    }

    @Test
    @ProbeTest(tags = "process")
    public void theSubtractionOfTwoIntegerThroughProcessShouldBeCorrect() {
        assertEquals(2, new OperationSub(3, 1).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "process" })
    public void theResultOfSubtractionOfTwoIntegerShouldBeTheSameForProcessAndCalculate() {
        assertEquals(new OperationSub(3, 1).process(), new OperationSub(3, 1).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessSubtractionWithLeftIntegerAndRightOperation() {
        assertEquals(2, new OperationSub(3, new OperationSub(3, 2)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsIntegerAndRightIsOperation() {
        assertNotEquals(2, new OperationSub(3, new OperationSub(3, 2)).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessSubtractionWithLeftOperationAndRightInteger() {
        assertEquals(-2, new OperationSub(new OperationSub(3, 2), 3).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsInteger() {
        assertNotEquals(-2, new OperationSub(new OperationSub(3, 2), 3).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessAnSubtractionWithLeftOperationAndRightAlso() {
        assertEquals(-2, new OperationSub(new OperationSub(3, 2), new OperationSub(3, 0)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsAlsoOperation() {
        assertNotEquals(-2, new OperationSub(new OperationSub(3, 2), new OperationSub(3, 0)).calculate());
    }
}
