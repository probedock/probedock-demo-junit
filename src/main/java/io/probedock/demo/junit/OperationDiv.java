package io.probedock.demo.junit;

/**
 * Divide operation
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class OperationDiv extends Operation {
    public OperationDiv(int leftOperand, int rightOperand) {
        super(leftOperand, rightOperand);
    }

    public OperationDiv(Operation leftOperation, Operation rightOperation) {
        super(leftOperation, rightOperation);
    }

    public OperationDiv(int leftOperand, Operation rightOperation) {
        super(leftOperand, rightOperation);
    }

    public OperationDiv(Operation leftOperation, int rightOperand) {
        super(leftOperation, rightOperand);
    }

    @Override
    public int calculate() {
        if (rightOperand == 0) {
            throw new IllegalStateException("Cannot divide by zero.");
        }
        else {
            return leftOperand / rightOperand;
        }
    }
}
