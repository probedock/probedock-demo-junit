package io.probedock.demo.junit;

/**
 * Subtraction operation
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class OperationSub extends Operation {

	public OperationSub(int leftOperand, int rightOperand) {
		super(leftOperand, rightOperand);
	}

	public OperationSub(Operation leftOperation, Operation rightOperation) {
		super(leftOperation, rightOperation);
	}

	public OperationSub(int leftOperand, Operation rightOperation) {
		super(leftOperand, rightOperation);
	}

	public OperationSub(Operation leftOperation, int rightOperand) {
		super(leftOperation, rightOperand);
	}

	@Override
	public int calculate() {
		return leftOperand - rightOperand;
	}

	@Override
	protected String getSymbol() {
		return "-";
	}

}
