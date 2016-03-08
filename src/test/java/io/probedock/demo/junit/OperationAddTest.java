package io.probedock.demo.junit;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import io.probedock.rt.client.junit.ProbeDockRTRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for class {@link OperationAdd}
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
//@RunWith(ProbeDockRTBlockJUnit4ClassRunner.class)
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tags = "add", tickets = "feature-1")
public class OperationAddTest {
    @Rule
    public ProbeDockRTRule filterRule = new ProbeDockRTRule();

    @Test
    @ProbeTest(tags = "calculate")
    public void theAdditionOfTwoIntegerThroughCalculateShouldBeCorrect() {
        assertEquals(4, new OperationAdd(1, 3).calculate());
    }

    @Test
    @ProbeTest(tags = "process")
    public void theAdditionOfTwoIntegerThroughProcessShouldBeCorrect() {
        assertEquals(4, new OperationAdd(1, 3).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "process" })
    public void theResultOfAdditionOfTwoIntegerShouldBeTheSameForProcessAndCalculate() {
        assertEquals(new OperationAdd(1, 3).process(), new OperationAdd(1, 3).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessAnAdditionWithLeftIntegerAndRightOperation() {
        assertEquals(4, new OperationAdd(1, new OperationAdd(1, 2)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsIntegerAndRightIsOperation() {
        assertNotEquals(4, new OperationAdd(1, new OperationAdd(1, 2)).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessAnAdditionWithLeftOperationAndRightInteger() {
        assertEquals(4, new OperationAdd(new OperationAdd(1, 2), 1).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsInteger() {
        assertNotEquals(4, new OperationAdd(new OperationAdd(1, 2), 1).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessAnAdditionWithLeftOperationAndRightAlso() {
        assertEquals(4, new OperationAdd(new OperationAdd(1, 2), new OperationAdd(1, 0)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsAlsoOperation() {
        assertNotEquals(4, new OperationAdd(new OperationAdd(1, 2), new OperationAdd(1, 0)).calculate());
    }
		
		@Test
		@ProbeTest(tags = { "symbol" })
		public void theOperationShouldReturnTheCorrectSymbol() {
			assertEquals("+", new OperationAdd(1, 1).getSymbol());
		}
		
		@Test
		@ProbeTest(tags = { "output" })
		public void itShouldBePossibleToPrintTheOperation() {
			assertEquals("( 1 + 2 )", new OperationAdd(1, 2).toString());
		}
}
