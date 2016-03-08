package io.probedock.demo.junit;

/**
 * Multiply operation
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class OperationMul extends Operation {

	public OperationMul(int leftOperand, int rightOperand) {
		super(leftOperand, rightOperand);
	}

	public OperationMul(Operation leftOperation, Operation rightOperation) {
		super(leftOperation, rightOperation);
	}

	public OperationMul(int leftOperand, Operation rightOperation) {
		super(leftOperand, rightOperation);
	}

	public OperationMul(Operation leftOperation, int rightOperand) {
		super(leftOperation, rightOperand);
	}

	@Override
	public int calculate() {
		return leftOperand * rightOperand;
	}

	@Override
	protected String getSymbol() {
		return "*";
	}

}
