package io.probedock.demo.junit;

/**
 * Add operation
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class OperationAdd extends Operation {
    public OperationAdd(int leftOperand, int rightOperand) {
        super(leftOperand, rightOperand);
    }

    public OperationAdd(Operation leftOperation, Operation rightOperation) {
        super(leftOperation, rightOperation);
    }

    public OperationAdd(int leftOperand, Operation rightOperation) {
        super(leftOperand, rightOperation);
    }

    public OperationAdd(Operation leftOperation, int rightOperand) {
        super(leftOperation, rightOperand);
    }

    @Override
    public int calculate() {
        return leftOperand + rightOperand;
    }
}
