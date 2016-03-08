package io.probedock.demo.junit;

/**
 * Composition operations
 *
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public abstract class Operation {

	private Operation leftOperation;
	private Operation rightOperation;

	protected int leftOperand;
	protected int rightOperand;

	/**
	 * Constructor for a simple operation without composition
	 *
	 * @param leftOperand Left operand is an integer
	 * @param rightOperand Right operand is an integer
	 */
	public Operation(int leftOperand, int rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	/**
	 * Constructor for a complex operation where left and right are also operations
	 *
	 * @param leftOperation Left is an operation
	 * @param rightOperation Right is an operation
	 */
	public Operation(Operation leftOperation, Operation rightOperation) {
		this.leftOperation = leftOperation;
		this.rightOperation = rightOperation;
	}

	/**
	 * Constructor for a complex operation where left is an integer and right another operation
	 *
	 * @param leftOperand Left is an integer
	 * @param rightOperation Right is an operation
	 */
	public Operation(int leftOperand, Operation rightOperation) {
		this.leftOperand = leftOperand;
		this.rightOperation = rightOperation;
	}

	/**
	 * Constructor for a complex operation where left is an operation and right is an integer
	 *
	 * @param leftOperation Left is an operation
	 * @param rightOperand Right is an integer
	 */
	public Operation(Operation leftOperation, int rightOperand) {
		this.leftOperation = leftOperation;
		this.rightOperand = rightOperand;
	}

	/**
	 * Process the operation and take care about the composition of the operations
	 *
	 * @return The result of all the operation
	 */
	public int process() {
		// Calculate the result of the left operation if any
		if (leftOperation != null) {
			leftOperand = leftOperation.process();
		}

		// Calculate the result of the right operation if any
		if (rightOperation != null) {
			rightOperand = rightOperation.process();
		}

		// Process the operation itself after the composition resolution
		return calculate();
	}

	public Operation getLeftOperation() {
		return leftOperation;
	}

	public Operation getRightOperation() {
		return rightOperation;
	}

	public int getLeftOperand() {
		return leftOperand;
	}

	public int getRightOperand() {
		return rightOperand;
	}

	@Override
	public String toString() {
		String left;

		if (leftOperation != null) {
			left = leftOperation.toString();
		}
		else {
			left = "" + leftOperand;
		}

		String right;

		if (rightOperation != null) {
			right = rightOperation.toString();
		}
		else {
			right = "" + rightOperand;
		}

		return "( " + left + " " + getSymbol() + " " + right + " )";
	}

	/**
	 * Delegates the operation between two integers to the subclasses
	 *
	 * @return The result of the calculus
	 */
	protected abstract int calculate();

	/**
	 * Retrieve the operation symbol
	 *
	 * @return The operation symbol
	 */
	protected abstract String getSymbol();
}
