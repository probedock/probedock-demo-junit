package io.probedock.demo.junit;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import io.probedock.rt.client.junit.ProbeDockRTRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test for class {@link OperationMul}
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
//@RunWith(ProbeDockRTBlockJUnit4ClassRunner.class)
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tags = "mul", tickets = "feature-3")
public class OperationMulTest {
    @Rule
    public ProbeDockRTRule filterRule = new ProbeDockRTRule();

    @Test
    @ProbeTest(tags = "calculate")
    public void theMultiplicationOfTwoIntegerThroughCalculateShouldBeCorrect() {
        assertEquals(6, new OperationMul(2, 3).calculate());
    }

    @Test
    @ProbeTest(tags = "process")
    public void theMultiplicationOfTwoIntegerThroughProcessShouldBeCorrect() {
        assertEquals(6, new OperationMul(2, 3).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "process" })
    public void theResultOfMultiplicationOfTwoIntegerShouldBeTheSameForProcessAndCalculate() {
        assertEquals(new OperationMul(2, 3).process(), new OperationMul(2, 3).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessMultiplicationWithLeftIntegerAndRightOperation() {
        assertEquals(6, new OperationMul(2, new OperationMul(1, 3)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsIntegerAndRightIsOperation() {
        assertNotEquals(6, new OperationMul(2, new OperationMul(1, 3)).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessMultiplicationWithLeftOperationAndRightInteger() {
        assertEquals(6, new OperationMul(new OperationMul(1, 3), 2).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsInteger() {
        assertNotEquals(6, new OperationMul(new OperationMul(1, 3), 2).calculate());
    }

    @Test
    @ProbeTest(tags = { "process", "composed" })
    public void itShouldBePossibleToProcessMultiplicationWithLeftOperationAndRightAlso() {
        assertEquals(6, new OperationMul(new OperationMul(1, 3), new OperationMul(2, 1)).process());
    }

    @Test
    @ProbeTest(tags = { "calculate", "composed" })
    public void itShouldNotReturnTheCorrectResultWhenCalculateIsUsedWhereLeftIsOperationAndRightIsAlsoOperation() {
        assertNotEquals(6, new OperationMul(new OperationMul(1, 3), new OperationMul(1, 2)).calculate());
    }
		
		@Test
		@ProbeTest(tags = { "symbol" })
		public void theOperationShouldReturnTheCorrectSymbol() {
			assertEquals("*", new OperationMul(1, 1).getSymbol());
		}
		
		@Test
		@ProbeTest(tags = { "output" })
		public void itShouldBePossibleToPrintTheOperation() {
			assertEquals("( 1 * 2 )", new OperationMul(1, 2).toString());
		}
}
